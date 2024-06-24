package org.example.productcatalogservice.controllers;

import org.example.productcatalogservice.dtos.ProductDto;
import org.example.productcatalogservice.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return new ArrayList<ProductDto>();
    }

    @GetMapping("{id}")
    public ProductDto getProduct(@PathVariable("id") Long productId) {
       ProductDto productDto = new ProductDto();
       productDto.setId(productId);
        return  productDto;
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productDto;
    }

    @PutMapping("{id}")
    public ProductDto replaceProduct(@PathVariable Long id,@RequestBody ProductDto productDto) {
        return productDto;
    }
}
