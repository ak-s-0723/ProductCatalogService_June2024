package org.example.productcatalogservice.repositories;

import org.example.productcatalogservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    Optional<Product> findById(Long id);
}
