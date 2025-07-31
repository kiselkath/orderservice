package com.example.orderservice.dto.response;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Response DTO sent back when an order is placed.
 */
public record OrderResponse(
        String id,
        LocalDateTime createdAt,
        List<OrderLineItemResponse> items
) {}

