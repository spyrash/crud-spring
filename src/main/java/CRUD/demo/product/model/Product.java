package CRUD.demo.product.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name="product")
public class Product {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-incrementing primary key
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "name is required validation by annotations")
    @Column(name = "name")
    private String name;
    @Size(min = 20, message = "description must be at least 20 characters long validation by annotations")
    @Column(name = "description")
    private String description;
    @PositiveOrZero(message = "price must be a positive number validation by annotations")
    @Column(name = "price")
    private Double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
