package CRUD.demo.product;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @PostMapping
    public String createProduct() {
        return "Product created successfully!";
    }

    @PutMapping
    public String updateProduct() {
        return "Product updated successfully!";
    }

    @DeleteMapping
    public String deleteProduct() {
        return "Product deleted successfully!";
    }

    @GetMapping
    public String getProduct() {
        return "Product details retrieved successfully!";
    }
}
