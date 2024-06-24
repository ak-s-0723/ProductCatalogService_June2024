package org.example.productcatalogservice.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.example.productcatalogservice.models.Category;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {
    private Long id;

    private String name;

    private String imageUrl;

    private String description;

    private Double price;

    private CategoryDto category;
}
