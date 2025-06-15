package CRUD.demo.product;

import CRUD.demo.product.model.Product;
import CRUD.demo.product.services.CreateProductService;
import CRUD.demo.product.services.DeleteProductService;
import CRUD.demo.product.services.GetProductService;
import CRUD.demo.product.services.UpdateProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     return createProductService.execute(null);
    }

    @PutMapping
    public ResponseEntity<String> updateProduct() {
        return updateProductService.execute(null);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProduct() {
        // Assuming the product is deleted successfully the "NO_CONTENT" status is returned and the body is ALWAYS empty.
        return deleteProductService.execute(null);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProduct() {
      return getProductService.execute(null);
    }
}
