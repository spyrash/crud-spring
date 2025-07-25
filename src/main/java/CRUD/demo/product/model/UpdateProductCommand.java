package CRUD.demo.product.model;

import lombok.Getter;

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
