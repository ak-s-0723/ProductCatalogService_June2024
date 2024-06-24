package org.example.productcatalogservice.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class BaseModel {
    private Long id;

    private Date createdAt;

    private Date lastUpdatedAt;

    private State state;
}
