package org.example.productcatalogservice.controllers;

import org.example.productcatalogservice.dtos.CategoryDto;
import org.example.productcatalogservice.dtos.ProductDto;
import org.example.productcatalogservice.models.Category;
import org.example.productcatalogservice.models.Product;
import org.example.productcatalogservice.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;



    @GetMapping
    public List<ProductDto> getAllProducts() {
        List<ProductDto> productDtos = new ArrayList<>();
        List<Product> products = productService.getAllProducts();
        for(Product product : products) {
            productDtos.add(from(product));
        }

        return productDtos;
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("id") Long productId) {
        try {
            if(productId < 1) {
                throw new IllegalArgumentException("Product not present");
            }
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("called by", "smart frontend");
            Product product = productService.getProductById(productId);
            if (product == null) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            ProductDto productDto = from(product);
            return new ResponseEntity<>(productDto, headers, HttpStatus.OK);
        }catch(IllegalArgumentException ex) {
            //return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
            throw ex;
        }
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        Product product = from(productDto);
        Product response = productService.createProduct(product);
        return from(response);
    }

    @PutMapping("{id}")
    public ProductDto replaceProduct(@PathVariable Long id,@RequestBody ProductDto productDto) {
        Product product = from(productDto);
        Product result = productService.replaceProduct(id,product);
        return from(result);
    }


    private Product from(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());
        product.setDescription(productDto.getDescription());
        product.setId(productDto.getId());  //This is important
        if(productDto.getCategory() !=null) {
            Category category = new Category();
            category.setName(productDto.getCategory().getName());
            category.setId(productDto.getCategory().getId());
            product.setCategory(category);
        }
        return product;
    }

    private ProductDto from(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setImageUrl(product.getImageUrl());
        if(product.getCategory() != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setName(product.getCategory().getName());
            categoryDto.setId(product.getCategory().getId());
            categoryDto.setDescription(product.getCategory().getDescription());
            productDto.setCategory(categoryDto);
        }

        return productDto;
    }
}
