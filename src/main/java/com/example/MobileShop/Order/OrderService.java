package com.example.MobileShop.Order;

import com.example.MobileShop.Address.Address;
import com.example.MobileShop.Address.AddressRepository;
import com.example.MobileShop.Order.Response.OrderResponse;
import com.example.MobileShop.User.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    public OrderResponse getOrderById(UUID id){
        Order order = orderRepository.findById(id).orElseThrow();
        Address address = addressRepository.findById(order.getAddress_id())
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + order.getAddress_id()));
        OrderResponse orderResponse = modelMapper.map(order, OrderResponse.class);

        // Set address in the response
        orderResponse.setAddress(address);

        return  orderResponse;
    }
}
