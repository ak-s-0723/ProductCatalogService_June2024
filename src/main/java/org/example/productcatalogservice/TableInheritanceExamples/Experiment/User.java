package org.example.productcatalogservice.TableInheritanceExamples.Experiment;

import jakarta.persistence.*;

@Entity(name="exp_user")
public class User {
    @Id
    private Long id;

    private String email;

    private String name;

    @Enumerated(EnumType.ORDINAL)
    private UserType userType;
}
