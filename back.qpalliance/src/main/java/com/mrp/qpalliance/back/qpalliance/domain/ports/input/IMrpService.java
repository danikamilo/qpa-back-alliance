package com.mrp.qpalliance.back.qpalliance.domain.ports.input;

import com.mrp.qpalliance.back.qpalliance.domain.model.Product;
import org.springframework.http.ResponseEntity;

/**
 * @author Daniel Camilo
 */
public interface IMrpService {

    /**
     *
     * @return
     */
    ResponseEntity<?> getAllProducts();

    /**
     *
     * @param product
     * @return
     */
    ResponseEntity<?> createProduct(Product product);

    /**
     *
     * @return
     */
    ResponseEntity<?> getStockAlerts();

}