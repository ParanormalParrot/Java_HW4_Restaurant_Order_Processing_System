package com.example.order_service.manager;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDishAddingRequest {
    private String email;
    private String specialRequests;
    private Integer dishId;
    private Integer quantity;
}
