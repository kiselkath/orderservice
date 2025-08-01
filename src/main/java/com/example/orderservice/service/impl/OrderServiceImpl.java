package com.example.orderservice.service.impl;

import com.example.orderservice.dto.request.CreateOrderRequest;
import com.example.orderservice.dto.request.OrderItemRequest;
import com.example.orderservice.dto.response.OrderLineItemResponse;
import com.example.orderservice.dto.response.OrderResponse;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderLineItem;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.service.client.InventoryClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

/**
 * Service implementation containing the business logic for placing orders.
 */
public class OrderServiceImpl {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    /**
     * Validates stock and saves order if valid.
     *
     * @param request CreateOrderRequest
     * @return OrderResponse
     */
    public OrderResponse placeOrder(CreateOrderRequest request) {
        List<OrderLineItem> items = new ArrayList<>();

        for (OrderItemRequest item : request.items()) {
            boolean available = inventoryClient.isInStock(item.productId(), item.quantity());
            if (!available) {
                throw new RuntimeException("Product " + item.productId() + " is out of stock.");
            }

            items.add(OrderLineItem.builder()
                    .productId(item.productId())
                    .quantity(item.quantity())
                    .build());
        }

        Order order = Order.builder()
                .createdAt(LocalDateTime.now())
                .items(items)
                .build();

        Order saved = orderRepository.save(order);

        return new OrderResponse(
                saved.getId(),
                saved.getCreatedAt(),
                saved.getItems().stream()
                        .map(i -> new OrderLineItemResponse(i.getProductId(), i.getQuantity()))
                        .toList()
        );
    }
}