package com.example.order_service.manager;

import com.example.hw4.authentification.Response;
import com.example.order_service.Order;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderResponse extends Response {
    private Order order;
}