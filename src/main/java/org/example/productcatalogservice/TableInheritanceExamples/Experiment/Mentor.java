package org.example.productcatalogservice.TableInheritanceExamples.Experiment;

import jakarta.persistence.Entity;

@Entity(name="exp_mentor")
public class Mentor extends User {
    private Long hours;
}
