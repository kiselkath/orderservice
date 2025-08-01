package com.example.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Order document to be stored in MongoDB.
 * Includes timestamp and list of ordered items.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "orders")
public class Order {

    // Unique identifier for the order
    @Id
    private String id;

    // Date and time when order was created
    private LocalDateTime createdAt;

    // List of ordered items
    private List<OrderLineItem> items;

    // TODO: Add constructors, getters, setters (or use Lombok)
}