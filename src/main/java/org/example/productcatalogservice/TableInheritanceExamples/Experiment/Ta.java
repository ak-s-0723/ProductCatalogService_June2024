package org.example.productcatalogservice.TableInheritanceExamples.Experiment;

import jakarta.persistence.Entity;

@Entity(name="exp_ta")
public class Ta extends User {
    private Double ratings;
}
