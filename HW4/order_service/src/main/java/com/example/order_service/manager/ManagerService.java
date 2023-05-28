package com.example.order_service.manager;

import com.example.order_service.Dish;
import com.example.hw4.repositories.UserRepository;
import com.example.order_service.Order;
import com.example.order_service.OrderDish;
import com.example.order_service.OrderStatus;
import com.example.order_service.repositories.DishRepository;
import com.example.order_service.repositories.OrderDishRepository;
import com.example.order_service.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;


@Service
@RequiredArgsConstructor
public class ManagerService {

    private final DishRepository dishRepository;
    private final OrderRepository orderRepository;
    private final OrderDishRepository orderDishRepository;
    private final UserRepository userRepository;

    public DishAddingResponse addDish(DishAddingRequest request) {
        var dish = Dish.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .isAvailable(true)
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();

        dishRepository.save(dish);
        return DishAddingResponse.builder()
                .dish(dish)
                .build();
    }

    public OrderAddingResponse addOrder(OrderAddingRequest request) {
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var order = Order.builder()
                .userId(user.getId())
                .status(OrderStatus.WAITING)
                .specialRequests(request.getSpecialRequests())
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
        orderRepository.save(order);
        var dishes = request.getDishes();
        for (var item: dishes) {
            var dish = dishRepository.findById(item.getId()).orElseThrow();
            var orderDish = OrderDish.builder()
                    .orderId(order.getId())
                    .dishId(item.getId())
                    .quantity(item.getQuantity())
                    .price(item.getQuantity() * dish.getPrice())
                    .build();
            orderDishRepository.save(orderDish);
        }
        manageOrders();
        return OrderAddingResponse.builder()
                .order(order)
                .build();
    }

    public GetMenuResponse getMenu() {
        List<Dish> menu = dishRepository.findByIsAvailable(true).orElseThrow();
        return GetMenuResponse.builder()
                .menu(menu)
                .build();
    }

    public GetOrderResponse getOrder(GetOrderRequest request) {
        var order = orderRepository.findById(request.getId()).orElseThrow();
        return GetOrderResponse.builder()
                .order(order)
                .build();
    }

    public void manageOrders() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                var orders = orderRepository.findAll();
                for (var item: orders) {
                    item.setStatus(OrderStatus.DONE);
                    item.setUpdatedAt(new Date());
                    orderRepository.save(item);
                }
            }
        };
        timer.schedule(task, 10000);
    }

    public DishAddingResponse updateDish(UpdateDishRequest request) {
        var dish = dishRepository.findById(request.getId()).orElseThrow();
        dish.setQuantity(request.getQuantity());
        dish.setUpdatedAt(new Date());
        dishRepository.save(dish);
        return DishAddingResponse.builder()
                .dish(dish)
                .build();
    }
}
