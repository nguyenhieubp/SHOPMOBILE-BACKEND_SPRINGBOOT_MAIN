package com.example.MobileShop.Order;


import com.example.MobileShop.Address.Address;
import com.example.MobileShop.Address.AddressDto;
import com.example.MobileShop.Address.AddressRepository;
import com.example.MobileShop.Order.Response.OrderResponse;
import com.example.MobileShop.User.User;
import com.example.MobileShop.User.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequestMapping("/api/v1/order")
@RestController
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderDto orderDto) {
        // Map OrderDto to Order entity
        Order order = modelMapper.map(orderDto, Order.class);

        // Fetch and set the user
        User user = userRepository.findById(orderDto.getUser())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + orderDto.getUser()));
        order.setUser(user);

        // Fetch and set the address
        Address address = addressRepository.findById(orderDto.getAddress_id())
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + orderDto.getAddress_id()));
        order.setAddress_id(orderDto.getAddress_id());

        // Save the order
        Order savedOrder = orderRepository.save(order);
        // Map saved order to OrderResponse
        OrderResponse orderResponse = modelMapper.map(savedOrder, OrderResponse.class);

        // Set address in the response
        orderResponse.setAddress(address);
        return ResponseEntity.ok(orderResponse);
    }


    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable UUID id) {
        OrderResponse orderResponse = orderService.getOrderById(id);
        return ResponseEntity.ok(orderResponse);
    }



    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderResponse> orderResponses = orders.stream()
                .map(order -> {
                    orderRepository.findById(order.getOrderId()).orElseThrow();
                    Address address = addressRepository.findById(order.getAddress_id())
                            .orElseThrow(() -> new RuntimeException("Address not found with id: " + order.getAddress_id()));
                    OrderResponse orderResponse = modelMapper.map(order, OrderResponse.class);

                    // Set address in the response
                    orderResponse.setAddress(address);
                    return orderResponse;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(orderResponses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteOrder(@PathVariable UUID id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));

        orderRepository.delete(order);
        return ResponseEntity.ok().body(true);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderResponse>> getOrdersByUserId(@PathVariable UUID userId) {
        List<Order> orders = orderRepository.findAllByUserId(userId);
        List<OrderResponse> orderResponses = orders.stream()
                .map(order -> {
                    orderRepository.findById(order.getOrderId()).orElseThrow();
                    Address address = addressRepository.findById(order.getAddress_id())
                            .orElseThrow(() -> new RuntimeException("Address not found with id: " + order.getAddress_id()));
                    OrderResponse orderResponse = modelMapper.map(order, OrderResponse.class);

                    // Set address in the response
                    orderResponse.setAddress(address);
                    return orderResponse;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(orderResponses);
    }
}
