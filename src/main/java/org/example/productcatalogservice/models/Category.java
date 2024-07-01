package org.example.productcatalogservice.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class Category extends BaseModel {
    private String name;

    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> product;
}
