package com.example.order_service.manager;

import com.example.hw4.authentification.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/order")
@RequiredArgsConstructor
public class OrderDishController {
    private final ManagerService managerService;


    @PostMapping("/add_dish")
    public ResponseEntity<Response> addDish(
            @RequestBody DishAddingRequest request
    ) {
        return ResponseEntity.ok(managerService.addDish(request));
    }

    @PostMapping("/add_order")
    public ResponseEntity<Response> addOrder(
            @RequestBody OrderAddingRequest request
    ) {
        return ResponseEntity.ok(managerService.addOrder(request));
    }

    @GetMapping("/get_menu")
    public ResponseEntity<Response> getMenu() {
        return ResponseEntity.ok(managerService.getMenu());
    }

    @GetMapping("/get_order")
    public ResponseEntity<Response> getOrder(
            @RequestBody GetOrderRequest request
    ) {
        return ResponseEntity.ok(managerService.getOrder(request));
    }
}
