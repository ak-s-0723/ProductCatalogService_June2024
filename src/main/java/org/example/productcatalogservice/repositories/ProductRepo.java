package org.example.productcatalogservice.repositories;

import org.example.productcatalogservice.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

    Page<Product> findProductsByName(String query, Pageable pageable);

    Optional<Product> findById(Long id);

    List<Product> findProductsByPriceBetween(Double low,Double high);

    List<Product> findAllByIsPrimeSpecific(Boolean value);

    List<Product> findAllByIsPrimeSpecificTrue();

    //List<Product> findAllByStateActive();

    List<Product> findAllByOrderByPriceDesc();

    @Query("SELECT p.name from Product p WHERE p.id=?1")
    String findProductNamefromId(Long id);

    @Query("SELECT c.name FROM Product p join Category c on p.category.id=c.id where p.id=:productId")
    String findCategoryNameFromProductId(Long productId);

}
