package com.mrp.qpalliance.back.qpalliance.infraestructure.adapter.output.jpa;

import com.mrp.qpalliance.back.qpalliance.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author Daniel Camilo
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.currentStock < p.minimumStock")
    List<Product> findProductsBelowMinimumStock();

    Optional<Product> findByCode(String code);
}