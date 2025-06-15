package CRUD.demo.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetProductService {
    public ResponseEntity<String> execute() {
        return ResponseEntity.status(HttpStatus.OK).body("Product details retrieved successfully!");
    }
}
