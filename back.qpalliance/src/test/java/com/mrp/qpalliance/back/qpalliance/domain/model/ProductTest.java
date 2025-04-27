package com.mrp.qpalliance.back.qpalliance.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * @author Daniel Camilo
 */
public class ProductTest {

    @Test
    void testProductConstructorAndGetters() {
        Product product = new Product("P001", "Test Product", 50);
        assertEquals("P001", product.getCode());
        assertEquals("Test Product", product.getName());
    }

    @Test
    void testSetters() {
        Product product = new Product();
        product.setCode("P002");
        product.setName("New Product");
        assertEquals("P002", product.getCode());
        assertEquals("New Product", product.getName());
    }
}
