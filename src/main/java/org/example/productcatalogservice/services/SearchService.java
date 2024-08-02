package org.example.productcatalogservice.services;


import org.example.productcatalogservice.dtos.SortParam;
import org.example.productcatalogservice.dtos.SortType;
import org.example.productcatalogservice.models.Product;
import org.example.productcatalogservice.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private ProductRepo productRepo;


    public Page<Product> searchProducts(String query, Integer pageNumber, Integer pageSize, List<SortParam> sortParams) {

        //Sort sort = Sort.by("price").and(Sort.by("id").descending());
        Sort sort = null;
        if(!sortParams.isEmpty()) {
            if(sortParams.get(0).getSortType().equals(SortType.ASC))
                sort = Sort.by(sortParams.get(0).getParamName());
            else
                sort = Sort.by(sortParams.get(0).getParamName()).descending();
        }

        for(int i=1;i<sortParams.size();i++) {
            if(sortParams.get(i).getSortType().equals(SortType.ASC))
                sort.and(Sort.by(sortParams.get(i).getParamName()));
            else
                sort.and(Sort.by(sortParams.get(i).getParamName()).descending());
        }


        return productRepo.findProductsByName(query, PageRequest.of(pageNumber,pageSize,sort));
    }
}
