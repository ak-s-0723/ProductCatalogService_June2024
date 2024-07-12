package org.example.productcatalogservice.controllers;

import org.example.productcatalogservice.dtos.ProductDto;
import org.example.productcatalogservice.models.Product;
import org.example.productcatalogservice.services.IProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private ProductController productController;

   @MockBean
    private IProductService productService;

   @Test
   public void Test_GetProductById_WithValidId_ReturnsProductSuccessfully() {
       //Arrange
       Long id = 1L;
       Product product = new Product();
       product.setId(id);
       product.setName("Iphone20");

//       when(productService.getProductById(any(Long.class)))
//       .thenReturn(product);
       when(productService.getProductById(id))
               .thenReturn(product);

       //Act
       ResponseEntity<ProductDto> response =
               productController.getProduct(id);

       //Assert
       assertNotNull(response.getBody());
       assertEquals(id,response.getBody().getId());
       assertEquals("Iphone20",response.getBody().getName());
   }

   @Test
   @DisplayName("paramter 0 resulted in product not present exception")
   public void Test_GetProductById_WithInvalidId_ThrowsException() {
       //Act and Assert
       Exception ex = assertThrows(IllegalArgumentException.class,
               () -> productController.getProduct(0L));

       assertEquals("Product not present",ex.getMessage());

       verify(productService,times(0))
               .getProductById(0L);
   }

   @Test
   public void Test_GetProductById_ProductServiceThrowsException() {
       //Arrange
       when(productService.getProductById(any(Long.class)))
               .thenThrow(new RuntimeException("something went bad"));

       //Act and Assert
       assertThrows(RuntimeException.class,
               () -> productController.getProduct(1L));
   }
}
