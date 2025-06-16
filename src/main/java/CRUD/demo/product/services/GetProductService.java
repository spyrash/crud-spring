package CRUD.demo.product.services;

import CRUD.demo.product.ProductRepository;
import CRUD.demo.product.Query;
import CRUD.demo.product.model.Product;
import CRUD.demo.product.model.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductService implements Query<Integer, ProductDto> {
    private final ProductRepository productRepository;

    public GetProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDto> execute(Integer productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        return productOptional.map(product -> ResponseEntity.ok(new ProductDto(product))).orElse(null);

        // in the future we will want to throw an exception here

    }
}
