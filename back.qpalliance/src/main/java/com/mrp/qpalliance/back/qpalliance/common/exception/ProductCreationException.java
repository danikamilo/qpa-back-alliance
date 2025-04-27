package com.mrp.qpalliance.back.qpalliance.common.exception;

/**
 * @author Daniel Camilo
 */
public class ProductCreationException extends RuntimeException {

    public ProductCreationException(String message) {
        super(message);
    }

    public ProductCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}