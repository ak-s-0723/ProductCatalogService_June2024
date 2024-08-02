package org.example.productcatalogservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class Category extends BaseModel {
    private String name;

    private String description;

    @OneToMany(mappedBy = "category",fetch= FetchType.LAZY)
    //@Fetch(FetchMode.SELECT)
    //@BatchSize(size = 10)
    @JsonBackReference
    private List<Product> product;
}

//N = num of categories
//N extra select queries
//batchsize - batch of that size of that queries
//
//cat = 4
//bs = 3
//number of queries = 1 + 2
//
//cat = 4
//bs = 1
//number of queries = 1 + 4