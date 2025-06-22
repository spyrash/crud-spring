package CRUD.demo.product;

import CRUD.demo.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByNameContaining(String name);

    //JPQL
    // Java Persistence Query Language
    @Query("SELECT p FROM Product p WHERE p.name LIKE %:keyword% OR p.description LIKE %:keyword%")
    List<Product> findByNameOrDescriptionContaining(@Param("keyword") String name);

    // if we do @Query(nativeQuery = true) then we can use native SQL queries but are no
    // longer db agnostic, we have to use table name not entity
    // since we do not use JPQL like this.
}
