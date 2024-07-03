package org.example.productcatalogservice.TableInheritanceExamples.Experiment;

import jakarta.persistence.Entity;

@Entity(name="exp_instructor")
public class Instructor extends User {
    private String company;
}
