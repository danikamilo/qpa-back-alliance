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
@RequestMapping(value = "/api/v1/mrp", produces = "application/json")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MrpResource {

    @Autowired
    private final IMrpService mrpService;

    @GetMapping("/products")
    public ResponseEntity<?> getProducts() {
        return mrpService.getAllProducts();
    }

    @PostMapping("/products")
    public ResponseEntity<Void> createProduct(@Valid @RequestBody Product product) {
        try {
            mrpService.createProduct(product); // Llama al servicio para crear el producto
            return new ResponseEntity<>(HttpStatus.CREATED); // Solo el código de estado 201 sin cuerpo
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Código de estado 400 en caso de error
        }
    }

    @GetMapping("/alerts")
    public ResponseEntity<?> getStockAlerts() {
        return mrpService.getStockAlerts();
    }
}
