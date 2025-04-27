package com.mrp.qpalliance.back.qpalliance.common.util;

/**
 * @author Daniel Camilo
 */
public class MrpConstants {

    private MrpConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String ERROR_CREATING_PRODUCT = "An error occurred while creating the product.";
    public static final String ERROR_FETCHING_PRODUCTS = "An error occurred while fetching the products.";
    public static final String ERROR_FETCHING_ALERTS = "An error occurred while fetching the stock alerts.";
    public static final String PRODUCT_CREATION_ERROR = "An error occurred while creating the product.";
    public static final String ENTITY_NOT_FOUND_ERROR = "Requested entity was not found.";
    public static final String GENERAL_ERROR = "An unexpected error occurred. Please try again later.";

}