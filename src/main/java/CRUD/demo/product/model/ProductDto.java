package CRUD.demo.product.model;

import lombok.Data;

@Data
public class ProductDto {
    private Integer id;
    private String name;
    private String description;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
    }
}
