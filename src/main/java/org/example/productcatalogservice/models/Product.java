package org.example.productcatalogservice.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product extends BaseModel {
    private String name;

    private String imageUrl;

    private String description;

    private Double price;

    private Category category;

    //private Boolean isPrimeSpecific;
}
