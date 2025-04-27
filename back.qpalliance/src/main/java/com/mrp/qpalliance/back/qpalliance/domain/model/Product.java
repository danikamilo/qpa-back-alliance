package com.mrp.qpalliance.back.qpalliance.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Daniel Camilo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name cannot be empty")
    public String name;
    @NotBlank(message = "Product code cannot be empty")
    @Column(unique = true)
    public String code;
    @Positive(message = "Current stock must be positive")
    public int currentStock;
    @Positive(message = "Minimum stock must be positive")
    public int minimumStock;

    public Product(String code, String name, int currentStock) {
        this.code = code;
        this.name = name;
        this.currentStock = currentStock;
        this.minimumStock = 1;
    }


}