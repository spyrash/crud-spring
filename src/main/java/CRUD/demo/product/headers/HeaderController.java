package CRUD.demo.product.headers;

import CRUD.demo.product.model.Product;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeaderController {

    @GetMapping("/header")
    public String getRegionalResponse(@RequestHeader(required = false, defaultValue = "US") String region) {
        // normally abstract this out into a service calss -> but we'll skip that for now
        return switch (region) {
            case "US" -> "BALD EAGLE FREEDOM";
            case "EU" -> "EUROPEAN UNION";
            case "CAN" -> "MAPLE SYRUP";
            default -> "Country not supported";
        };

    }

    @GetMapping(value = "/header/product", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Product> getProduct() {
        Product product = new Product();
        product.setId(1);
        product.setName("cool product name!");
        product.setDescription("cool product description!");

        return ResponseEntity.ok(product);
    }
}

