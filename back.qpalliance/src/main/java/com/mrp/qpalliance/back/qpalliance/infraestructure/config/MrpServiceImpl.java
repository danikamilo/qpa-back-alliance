package com.mrp.qpalliance.back.qpalliance.infraestructure.config;

import com.mrp.qpalliance.back.qpalliance.common.exception.MrpException;
import com.mrp.qpalliance.back.qpalliance.common.util.MrpConstants;
import com.mrp.qpalliance.back.qpalliance.domain.model.Product;
import com.mrp.qpalliance.back.qpalliance.domain.ports.input.IMrpService;
import com.mrp.qpalliance.back.qpalliance.infraestructure.adapter.output.jpa.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Daniel Camilo
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MrpServiceImpl implements IMrpService {

    @Autowired
    private final ProductRepository productRepository;

    @Override
    public ResponseEntity<?> getAllProducts() {
        log.info("Executing getAllProducts");
        try {
            List<Product> products = productRepository.findAll();
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            log.error("Error fetching all products", e);
            throw new MrpException(MrpConstants.ERROR_FETCHING_PRODUCTS);
        }
    }

    @Override
    public ResponseEntity<?> createProduct(Product product) {
        log.info("Executing createProduct");
        try {
            Product savedProduct = productRepository.save(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
        } catch (Exception e) {
            log.error("Error creating product", e);
            throw new MrpException(MrpConstants.ERROR_CREATING_PRODUCT);
        }
    }

    @Override
    public ResponseEntity<?> getStockAlerts() {
        log.info("Executing getStockAlerts");
        try {
            List<Product> alertProducts = productRepository.findProductsBelowMinimumStock();
            return ResponseEntity.ok(alertProducts);
        } catch (Exception e) {
            log.error("Error fetching stock alerts", e);
            throw new MrpException(MrpConstants.ERROR_FETCHING_ALERTS);
        }
    }
}