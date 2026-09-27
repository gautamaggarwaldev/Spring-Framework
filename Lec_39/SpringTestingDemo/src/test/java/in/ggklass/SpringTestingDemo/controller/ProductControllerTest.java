package in.ggklass.SpringTestingDemo.controller;

import in.ggklass.SpringTestingDemo.entity.Product;
import in.ggklass.SpringTestingDemo.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.springframework.http.MediaType;

@WebMvcTest
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductService productService;

    @Test
    void shouldReturnProductIfProductExist() throws Exception {
        // arrange
        Product product = new Product(1L, "Laptop", 150000, 250);

        when(productService.getProductById(1L)).thenReturn(product);

        //Act and assertion
        mockMvc.perform(get("/api/products/1")
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(
                        MediaType.APPLICATION_JSON
                ))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Laptop"))
                .andExpect(jsonPath("$.price").value(150000))
                .andExpect(jsonPath("$.stock").value(250));

        verify(productService).getProductById(1L);
    }

    @Test
    void shouldCreateProduct() throws Exception {

        // Arrange
        Product product = new Product(1L, "Laptop", 150000, 250);

        when(productService.createProduct(any(Product.class)))
                .thenReturn(product);

        // Act + Assert
        mockMvc.perform(
                        post("/api/products")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                                    {
                                        "name": "Laptop",
                                        "price": 150000,
                                        "stock": 250
                                    }
                                    """)
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Laptop"))
                .andExpect(jsonPath("$.price").value(150000))
                .andExpect(jsonPath("$.stock").value(250));

        // Verify service was called
        verify(productService).createProduct(any(Product.class));
    }
}
