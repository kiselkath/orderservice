package com.example.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents a single product item in the order.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "OrderLineItems")
public class OrderLineItem {

    // Product identifier
    private Long productId;

    // Quantity ordered
    private int quantity;
}