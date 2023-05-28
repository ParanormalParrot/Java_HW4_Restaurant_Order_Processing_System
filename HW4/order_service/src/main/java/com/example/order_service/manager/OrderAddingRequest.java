package com.example.order_service.manager;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderAddingRequest {
    private String email;
    private List<DishQuantity> dishes;
    private String specialRequests;
}
