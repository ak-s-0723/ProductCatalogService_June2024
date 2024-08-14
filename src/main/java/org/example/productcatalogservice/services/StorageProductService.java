package org.example.productcatalogservice.services;

import org.example.productcatalogservice.dtos.UserDto;
import org.example.productcatalogservice.models.Product;
import org.example.productcatalogservice.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Primary
@Service
public class StorageProductService implements IProductService {
    private ProductRepo productRepo;

    private RestTemplate restTemplate;

    public StorageProductService(ProductRepo productRepo,RestTemplate restTemplate) {
        this.productRepo = productRepo;
        this.restTemplate = restTemplate;
    }


    @Override
    public Product getProductById(Long id) {
       Optional<Product> productOptional = productRepo.findById(id);
       if(productOptional.isPresent()) {
           return productOptional.get();
       }

       return null;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        Product result = productRepo.save(product);
        return result;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product getProductBasedOnScope(Long pid, Long uid) {
        Product product = productRepo.findById(pid).get();
        UserDto userDto = restTemplate.getForEntity("http://userservice/users/{uid}", UserDto.class,uid).getBody();
        System.out.println("EMAIL = " +userDto.getEmail());
        return product;
    }
}
