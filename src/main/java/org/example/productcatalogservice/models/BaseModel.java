package org.example.productcatalogservice.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@MappedSuperclass
public abstract class BaseModel {
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private Date createdAt;

    private Date lastUpdatedAt;

    private State state;
}
