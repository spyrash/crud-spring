package CRUD.demo.product.services;

import CRUD.demo.product.Command;
import CRUD.demo.product.ProductRepository;
import CRUD.demo.product.model.Product;
import CRUD.demo.product.model.ProductDto;
import CRUD.demo.product.model.UpdateProductCommand;
import CRUD.demo.product.validators.ProductValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProductService implements Command<UpdateProductCommand, ProductDto>  {

    private final ProductRepository productRepository;

    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDto> execute(UpdateProductCommand command) {
        Optional<Product> productOptional = productRepository.findById(command.getId());
        if (productOptional.isPresent()) {
            Product product = command.getProduct();
            // commented to use assertion on entity
            //ProductValidator.execute(product);
            product.setId(command.getId());
            productRepository.save(product);
            return ResponseEntity.ok(new ProductDto(product));
        }
        // In the future, we will want to throw an exception here
        return null;
    }
}
