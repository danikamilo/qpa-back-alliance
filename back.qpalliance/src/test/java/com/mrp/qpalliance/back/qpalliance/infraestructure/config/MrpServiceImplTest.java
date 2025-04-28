package com.mrp.qpalliance.back.qpalliance.infraestructure.config;

import com.mrp.qpalliance.back.qpalliance.domain.model.Product;
import com.mrp.qpalliance.back.qpalliance.infraestructure.adapter.output.jpa.ProductRepository;
import com.mrp.qpalliance.back.qpalliance.infraestructure.service.MrpServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MrpServiceImplTest {

    @Autowired
    private MrpServiceImpl mrpService;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        mrpService = new MrpServiceImpl(productRepository);
    }

    @Test
    void createProduct_success() {
        Product product = new Product("P001", "Product Test", 100);
        when(productRepository.save(product)).thenReturn(product);
        ResponseEntity<Product> savedProduct = (ResponseEntity<Product>) mrpService.createProduct(product);
        assertNotNull(savedProduct);
        assertEquals("P001", savedProduct.getBody().getCode());
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void getProductByCode_success() {
        Product product = new Product("P001", "Product Test", 100);
        when(productRepository.findByCode("P001")).thenReturn(Optional.of(product));
        Optional<Product> foundProduct = productRepository.findByCode("P001");
        assertNotNull(foundProduct);
        assertEquals("P001", foundProduct.get().getCode());
    }

    @Test
    void getProductByCode_notFound() {
        when(productRepository.findByCode("P001")).thenReturn(Optional.empty());
        assertEquals(Optional.empty(), productRepository.findByCode("P0012"));
    }
}