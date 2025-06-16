package CRUD.demo.product.model;

import CRUD.demo.product.Command;
import CRUD.demo.product.ProductRepository;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@Getter
public class UpdateProductCommand {
    private Integer id;
    private Product product;

    public UpdateProductCommand(
    Integer id,
    Product product
    ) {
        this.id = id;
        this.product = product;
    }
}
