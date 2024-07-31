package org.example.productcatalogservice.repositories;

import jakarta.transaction.Transactional;
import org.example.productcatalogservice.models.Category;
import org.example.productcatalogservice.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepoTest {

    @Autowired
    private ProductRepo productRepo;

    @Test
    @Transactional
    public void testJpaQueries() {
       //List<Product> productList = productRepo.findProductsByPriceBetween(6499D,70000D);
        //List<Product> productList = productRepo.findAllByOrderByPriceDesc();
//        Optional<Product> optionalProduct = productRepo.findById(1L);
//        if(optionalProduct.isPresent()) {
//            System.out.println(optionalProduct.get().getName());
//        }

        //String productName = productRepo.findProductNamefromId(1L);
        System.out.println(productRepo.findCategoryNameFromProductId(1L));
    }

    @Test
    public void insertIntoAWSDb() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Krishna");
        product.setDescription("Learner");
        Category category = new Category();
        category.setName("Learners");
        category.setId(10L);
        product.setCategory(category);
        productRepo.save(product);
    }

}