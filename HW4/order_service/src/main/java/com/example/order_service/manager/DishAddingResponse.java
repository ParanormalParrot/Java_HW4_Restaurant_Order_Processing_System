package com.example.order_service.manager;
import com.example.hw4.authentification.Response;
import com.example.order_service.Dish;
import lombok.*;
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DishAddingResponse extends Response {
    private Dish dish;
}
