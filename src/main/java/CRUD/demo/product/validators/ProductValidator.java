package CRUD.demo.product.validators;

import CRUD.demo.exceptions.ProductNotValidException;
import CRUD.demo.product.model.Product;

public class ProductValidator {
    public ProductValidator() {}

    public static void execute(Product product) {
        if (product.getName().isBlank()) {
            throw new ProductNotValidException("Product name is required");
        }
        if (product.getDescription().length() < 20) {
            throw new ProductNotValidException("Description must be at least 20 characters long");
        }
        if (product.getPrice() == null || product.getPrice() < 0) {
            throw new ProductNotValidException("Price must be a positive number");
        }
    }
}
