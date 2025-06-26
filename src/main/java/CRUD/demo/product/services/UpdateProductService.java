package CRUD.demo.product.services;

import CRUD.demo.product.Command;
import CRUD.demo.product.ProductRepository;
import CRUD.demo.product.model.Product;
import CRUD.demo.product.model.ProductDto;
import CRUD.demo.product.model.UpdateProductCommand;
import CRUD.demo.product.validators.ProductValidator;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
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
    //@CacheEvict(value = "productCache", key = "#command.getId()")
    @CachePut(value = "productCache", key = "#command.getId()")
    // evict -> throws away the cache entry for the given key
    // put -> throws it away and then put the return value of the method in the cache
    public ResponseEntity<ProductDto> execute(UpdateProductCommand command) {
        // OSS: the 'key' in CacheEvict must match the value we use in the findById method
        // essentially we are saying to do a Cache evict when we with a value key pair
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
