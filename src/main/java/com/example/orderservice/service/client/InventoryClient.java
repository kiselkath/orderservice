package com.example.orderservice.service.client;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * REST client to communicate with Inventory-Service.
 * Should verify stock availability before placing an order.
 */


@Service
@RequiredArgsConstructor
public class InventoryClient {


    private final RestTemplate restTemplate;

    public boolean isInStock(Long productId, int quantity) {
        // Сформируй URL запроса
        String url = "http://inventory-service/api/inventory/check?productId=" + productId + "&quantity=" + quantity;

        // Отправь GET-запрос и получи ответ
        ResponseEntity<Boolean> response = restTemplate.getForEntity(url, Boolean.class);

        // Верни true, если товар есть в наличии
        return Boolean.TRUE.equals(response.getBody());
    }
}