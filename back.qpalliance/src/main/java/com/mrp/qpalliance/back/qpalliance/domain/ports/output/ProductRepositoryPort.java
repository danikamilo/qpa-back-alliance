package com.mrp.qpalliance.back.qpalliance.domain.ports.output;

import com.mrp.qpalliance.back.qpalliance.domain.model.Product;
import java.util.List;

/**
 * @author Daniel Camilo
 */
public interface ProductRepositoryPort {

    /**
     *
     * @param product
     * @return
     */
    Product save(Product product);

    /**
     *
     * @return
     */
    List<Product> findAll();

    /**
     *
     * @return
     */
    List<Product> findProductsBelowMinimumStock();
}