package org.example.productcatalogservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class SearchRequestDto {
    private String query;

    private Integer pageLimit;

    private Integer pageNumber;

    private List<SortParam> sortParamList = new ArrayList<>();
}


/*

{
    "query" : "laptop",
    "pageNumber" : 0,
    "pageLimit": 8,
    "sortParamList" : [
        {
            "paramName" : "price",
            "sortType" : "DESC"
        },
        {
            "paramName" : "id",
            "sortType" : "ASC"
        }
    ]
}

 */