package CRUD.demo.product;

import CRUD.demo.exceptions.AltraException;
import CRUD.demo.product.model.Product;
import CRUD.demo.product.model.ProductDto;
import CRUD.demo.product.model.UpdateProductCommand;
import CRUD.demo.product.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    // autowired is not recommended in modern Spring applications, but it is still used in some legacy projects
   // @Autowired
   // private CreateProductService createProductService;

    private final CreateProductService createProductService;
    private final GetProductsService getProductsService;
    private final GetProductService getProductService;
    private final DeleteProductService deleteProductService;
    private final UpdateProductService updateProductService;

    public ProductController (
            CreateProductService createProductService,
            GetProductsService getProductsService,
            GetProductService getProductService,
            DeleteProductService deleteProductService,
            UpdateProductService updateProductService
            ) {
        this.createProductService = createProductService;
        this.getProductsService = getProductsService;
        this.getProductService = getProductService;
        this.deleteProductService = deleteProductService;
        this.updateProductService = updateProductService;
    }

    @PostMapping("/product")
    public ResponseEntity<ProductDto> createProduct(@RequestBody Product product) {
        return createProductService.execute(product);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        return updateProductService.execute(new UpdateProductCommand(id, product));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        // Assuming the product is deleted successfully the "NO_CONTENT" status is returned and the body is ALWAYS empty.
        return deleteProductService.execute(id);
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductDto>> getProduct() {
      return getProductsService.execute(null);
    }

    // new get mapping to get a product by ID

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Integer id) {
        return getProductService.execute(id);
    }

    @ExceptionHandler(AltraException.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(500).body("got the other exception, no at controller level!");
        // This work for all the routes inside this controller
        // you can also use @ControllerAdvice to handle exceptions globally
        // creating a class with @ControllerAdvice annotation and this method inside it
    }

}
