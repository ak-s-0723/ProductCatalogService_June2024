package org.example.productcatalogservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private Long id;

    private String title;

    private String description;

    private Double price;

    private String category;

    private String image;

    private FakeStoreRatingDto fakeStoreRatingDto;
}
