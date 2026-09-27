package in.ggklass.SpringTestingDemo.service;

import in.ggklass.SpringTestingDemo.entity.Product;
import in.ggklass.SpringTestingDemo.repository.ProductRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void shouldReturnProductWhenProductExist() {
//        arrange
        Product product = new Product(1L, "Laptop", 150000, 250);

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

//        act
        Product actualResult = productService.getProductById(1L);

        assertEquals(1L, actualResult.getId());
        assertEquals("Laptop", actualResult.getName());
        assertEquals(150000, actualResult.getPrice());
        assertEquals(250, actualResult.getStock());

        verify(productRepository).findById(1L);
    }

    @Test
    void shouldThrowExceptionWhenProductDoesNotExist() {
        //Arrange
        when(productRepository.findById(99L)).thenReturn(Optional.empty());

        //Act
        RuntimeException exception = assertThrows(RuntimeException.class, () -> productService.getProductById(99L));


        // assertion
        assertEquals("Product not found: 99", exception.getMessage());
        verify(productRepository).findById(99L);
    }

    @Test
    void shouldCreateProductWhenNameIsUnique() {
        // Arrange
        Product request =
                new Product(null, "Keyboard", 200, 5);

        Product savedProduct =
                new Product(10L, "Keyboard", 200, 5);

        when(productRepository.existsByName("Keyboard"))
                .thenReturn(false);

        when(productRepository.save(request))
                .thenReturn(savedProduct);

        // Act
        Product result =
                productService.createProduct(request);

        // Assert
        assertEquals(10L, result.getId());
        assertEquals("Keyboard", result.getName());

        verify(productRepository)
                .existsByName("Keyboard");

        verify(productRepository)
                .save(request);
    }

    @Test
    void shouldRejectProductWhenNameAlreadyExists() {

        // Arrange
        Product request =
                new Product(null, "Keyboard", 200, 5);

        when(productRepository.existsByName("Keyboard"))
                .thenReturn(true);

        // Act and Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> productService.createProduct(request)
        );

        verify(productRepository)
                .existsByName("Keyboard");

        verify(productRepository, never())
                .save(any(Product.class));
    }
}
