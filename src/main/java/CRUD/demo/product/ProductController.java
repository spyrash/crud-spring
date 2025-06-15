package CRUD.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    // autowired is not recommended in modern Spring applications, but it is still used in some legacy projects
   // @Autowired
   // private CreateProductService createProductService;

    private final CreateProductService createProductService;
    private final GetProductService getProductService;
    private final DeleteProductService deleteProductService;
    private final UpdateProductService updateProductService;

    public ProductController (
            CreateProductService createProductService,
            GetProductService getProductService,
            DeleteProductService deleteProductService,
            UpdateProductService updateProductService
            ) {
        this.createProductService = createProductService;
        this.getProductService = getProductService;
        this.deleteProductService = deleteProductService;
        this.updateProductService = updateProductService;
    }

    @PostMapping
    public ResponseEntity<String> createProduct() {
     return createProductService.execute();
    }

    @PutMapping
    public ResponseEntity<String> updateProduct() {
        return updateProductService.execute();
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProduct() {
        // Assuming the product is deleted successfully the "NO_CONTENT" status is returned and the body is ALWAYS empty.
        return deleteProductService.execute();
    }

    @GetMapping
    public ResponseEntity<String> getProduct() {
      return getProductService.execute();
    }
}
