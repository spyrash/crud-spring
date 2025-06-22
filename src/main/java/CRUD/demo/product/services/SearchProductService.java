package CRUD.demo.product.services;

import CRUD.demo.product.ProductRepository;
import CRUD.demo.product.Query;
import CRUD.demo.product.model.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchProductService implements Query<String, List<ProductDto>> {
    private final ProductRepository productRepository;

    public SearchProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<List<ProductDto>> execute(String input) {
        // findByNameOrDescriptionContaining to test it
        return ResponseEntity.ok(productRepository.findByNameOrDescriptionContaining(input)
                .stream()
                .map(ProductDto::new)
                .toList());
    }
}
