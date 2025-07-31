package com.example.orderservice.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * Request DTO to receive order creation input.
 * Includes a list of product items.
 */
public record CreateOrderRequest(
        @NotNull List<OrderItemRequest> items
) {}

