package org.example.productcatalogservice.services;

import org.example.productcatalogservice.clients.FakeStoreApiClient;
import org.example.productcatalogservice.dtos.FakeStoreProductDto;
import org.example.productcatalogservice.models.Category;
import org.example.productcatalogservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements IProductService {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    private FakeStoreApiClient fakeStoreApiClient;


    @Override
    public List<Product> getAllProducts() {
           List<Product> products = new ArrayList<>();
           RestTemplate restTemplate = restTemplateBuilder.build();
           FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForEntity("http://fakestoreapi.com/products",FakeStoreProductDto[].class).getBody();
           for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
               products.add(from(fakeStoreProductDto));
           }
       return products;
    }

    @Override
    public Product getProductById(Long id) {
        return from(fakeStoreApiClient.getProductById(id));
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }


    @Override
    public Product replaceProduct(Long id,Product product) {
        FakeStoreProductDto fakeStoreProductDtoReq = from(product);
        FakeStoreProductDto fakeStoreProductDtoResponse = fakeStoreApiClient.replaceProduct(id,fakeStoreProductDtoReq);
        return from(fakeStoreProductDtoResponse);
    }

    private Product from(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setName(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());
        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }

    private FakeStoreProductDto from(Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setImage(product.getImageUrl());
        fakeStoreProductDto.setTitle(product.getName());
        if(product.getCategory() != null) {
            fakeStoreProductDto.setCategory(product.getCategory().getName());
        }
        fakeStoreProductDto.setDescription(product.getDescription());

        return fakeStoreProductDto;
    }


}


//Controller   ->   Service   -> FakeStore
//ProductDto      Product        FakeStoreDto