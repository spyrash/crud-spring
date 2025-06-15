package CRUD.demo.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @PostMapping
    public ResponseEntity<String> createProduct() {
        return ResponseEntity.status(HttpStatus.CREATED).body("Product created successfully!");
    }

    @PutMapping
    public ResponseEntity<String> updateProduct() {
        return ResponseEntity.status(HttpStatus.OK).body("Product updated successfully!");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProduct() {
        // Assuming the product is deleted successfully the "NO_CONTENT" status is returned and the body is ALWAYS empty.
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }

    @GetMapping
    public ResponseEntity<String> getProduct() {
        return ResponseEntity.status(HttpStatus.OK).body("Product details retrieved successfully!");
    }
}
