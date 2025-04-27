package com.mrp.qpalliance.back.qpalliance.infraestructure.adapter.input;

import com.mrp.qpalliance.back.qpalliance.domain.model.Product;
import com.mrp.qpalliance.back.qpalliance.domain.ports.input.IMrpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Daniel Camilo
 */
@RestController
@RequestMapping("/api/v1/mrp")
@RequiredArgsConstructor
public class MrpResource {

    @Autowired
    private final IMrpService mrpService;

    @GetMapping("/products")
    public ResponseEntity<?> getProducts() {
        return mrpService.getAllProducts();
    }

    @PostMapping("/products")
    public ResponseEntity<String> createProduct(@Valid @RequestBody Product product) {
        try {
            mrpService.createProduct(product);
            return new ResponseEntity<>("Product created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/alerts")
    public ResponseEntity<?> getStockAlerts() {
        return mrpService.getStockAlerts();
    }
}
