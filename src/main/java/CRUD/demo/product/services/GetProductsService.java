package CRUD.demo.product.services;

import CRUD.demo.product.ProductRepository;
import CRUD.demo.product.Query;
import CRUD.demo.product.model.Product;
import CRUD.demo.product.model.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductsService implements Query<Void, List<ProductDto>> {

    private final ProductRepository productRepository;

    public GetProductsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<List<ProductDto>> execute(Void input) {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = products.stream()
                .map(ProductDto::new)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(productDtos);
    }
}
