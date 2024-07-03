package org.example.productcatalogservice.TableInheritanceExamples.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="st_instructor")
@DiscriminatorValue(value="3")
public class Instructor extends User {
    private String company;
}
