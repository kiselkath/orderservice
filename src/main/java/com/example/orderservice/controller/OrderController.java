package com.example.orderservice.controller;

import jakarta.validation.Valid;
import com.example.orderservice.dto.request.CreateOrderRequest;
import com.example.orderservice.dto.response.OrderResponse;

/**
 * REST controller for /api/orders endpoints.
 */
public class OrderController {

    // TODO: Inject service

    /**
     * POST endpoint to create an order.
     */
    public OrderResponse create(@Valid CreateOrderRequest request) {
        // TODO: Call order service and return response
        return null;
    }
}