package CRUD.demo;

import CRUD.demo.exceptions.ProductNotFoundException;
import CRUD.demo.product.ProductRepository;
import CRUD.demo.product.model.Product;
import CRUD.demo.product.model.ProductDto;
import CRUD.demo.product.services.GetProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class GetProductServiceTest {
    @Mock // what to mock the response of -> need this dependency to run the test
    private ProductRepository productRepository;

    @InjectMocks // the thing we are testing
    private GetProductService getProductService;

    @BeforeEach // things we need before the test runs to set up properly
    public void setup() {
        // Initialize mocks and inject them into the service
        // This is typically done by a mocking framework like Mockito
        // For example: MockitoAnnotations.openMocks(this);

        //initialize the repository & the service
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void given_product_exists_when_get_product_service_return_product_dto() {
        //given
        Product product = new Product();
        product.setId(1);
        product.setName("Product Name");
        product.setDescription("Product Description is at least 20 chars");
        product.setPrice(9.99);

        // this says 'when' but it's actually still setting up
        when(productRepository.findById(1)).thenReturn(Optional.of(product));
        //when
        ResponseEntity<ProductDto> response = getProductService.execute(1);
        //then
        assertEquals(ResponseEntity.ok(new ProductDto(product)), response);
        // asserts the product repository was only called once
        verify(productRepository, times(1)).findById(1);
    }

    @Test
    public void given_product_does_not_exist_when_get_product_service_throw_product_not_found_exception() {
        //given
        when(productRepository.findById(1)).thenReturn(Optional.empty());

        // when & thenthen
        assertThrows(ProductNotFoundException.class, () -> getProductService.execute(1));
        verify(productRepository, times(1)).findById(1);
    }
}
