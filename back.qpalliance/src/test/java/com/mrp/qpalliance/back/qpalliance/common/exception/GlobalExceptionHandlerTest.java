package com.mrp.qpalliance.back.qpalliance.common.exception;

import com.mrp.qpalliance.back.qpalliance.common.util.MrpConstants;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;

public class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    void testHandleProductCreationException() {
        ProductCreationException exception = new ProductCreationException("Error creating product");
        ResponseEntity<String> response = handler.handleProductCreationException(exception);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(MrpConstants.PRODUCT_CREATION_ERROR, response.getBody());
    }

    @Test
    void testHandleGenericException() {
        Exception exception = new Exception("Generic error");
        ResponseEntity<String> response = handler.handleGeneralException(exception);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(MrpConstants.GENERAL_ERROR, response.getBody());
    }
}