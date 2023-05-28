package com.example.order_service.manager;

import com.example.hw4.Dish;
import com.example.hw4.authentification.Response;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMenuResponse extends Response {

    private List<Dish> menu;
}