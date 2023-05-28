package com.example.order_service.manager;
import com.example.hw4.authentification.Response;
import com.example.order_service.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderAddingResponse extends Response {
    private Order order;
}
