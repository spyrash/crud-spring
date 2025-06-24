package CRUD.demo.mappings;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "address")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name="customer_id")
    private Integer customerId;

    @ManyToMany(mappedBy = "addresses")
    @JsonIgnore // Prevents infinite recursion during serialization since this is a circular reference
    private List<Customer> customers;
}
