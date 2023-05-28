package com.example.order_service.manager;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DishAddingRequest {

    private String name;
    private String description;
    private Integer price;
    private Integer quantity;

}
