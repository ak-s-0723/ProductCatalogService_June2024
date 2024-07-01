package org.example.productcatalogservice.services;

import org.example.productcatalogservice.models.Product;
import org.example.productcatalogservice.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class StorageProductService implements IProductService {

    @Autowired
    private ProductRepo productRepo;

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
        return null;
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
}
