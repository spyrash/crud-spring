package CRUD.demo.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(ProductNotFoundException.class);
    public ProductNotFoundException() {
        super("Product not found");
        logger.error("exception {} thrown", getClass());
    }
}
