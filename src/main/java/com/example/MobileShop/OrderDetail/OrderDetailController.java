package com.example.MobileShop.OrderDetail;

import com.example.MobileShop.Order.Order;
import com.example.MobileShop.Order.OrderService;
import com.example.MobileShop.OrderDetail.OrderResponse.OrderDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orderDetail")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping("/create")
    public void createOrderDetail(@RequestBody OrderDetailDto orderDetailDto){
        orderDetailService.createOrderDetail(orderDetailDto);
    }
}
