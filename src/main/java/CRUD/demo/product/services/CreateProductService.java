package CRUD.demo.product.services;

import CRUD.demo.exceptions.ProductNotValidException;
import CRUD.demo.product.Command;
import CRUD.demo.product.ProductRepository;
import CRUD.demo.product.model.Product;
import CRUD.demo.product.model.ProductDto;
import CRUD.demo.product.validators.ProductValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class CreateProductService implements Command<Product, ProductDto> {

    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDto> execute(Product product) {
        // commented to use assertion on entity
        //ProductValidator.execute(product);
        Product savedProduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDto(savedProduct));
    }
}
