package com.example.MobileShop.OrderDetail;

import com.example.MobileShop.Order.OrderService;
import com.example.MobileShop.Order.Response.OrderResponse;
import com.example.MobileShop.OrderDetail.OrderResponse.OrderDetailResponse;
import com.example.MobileShop.PhoneVariable.PhoneVariable;
import com.example.MobileShop.PhoneVariable.PhoneVariableRepository;
import com.example.MobileShop.PhoneVariable.PhoneVariableService;
import com.example.MobileShop.PhoneVariable.response.ResponsePhoneVariable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrderService orderService;

    @Autowired
    private PhoneVariableService phoneVariableService;

    public void createOrderDetail(OrderDetailDto orderDetailDto ){
//        System.out.println("DATA "+orderDetailDto);
        OrderDetail orderDetail = modelMapper.map(orderDetailDto,OrderDetail.class);
//        System.out.println("RR "+orderDetail);
        OrderDetail data = orderDetailRepository.save(orderDetail);
//
//        orderDetailRepository.save(data);
//
//        OrderDetailResponse orderDetailResponse = modelMapper.map(data,OrderDetailResponse.class);
//
//        ResponsePhoneVariable phoneVariable = phoneVariableService.getPhoneVariableById(data.getProduct_item_id());
//        OrderResponse orderResponse = orderService.getOrderById(data.getOrderDetailId());
//        orderDetailResponse.setResponsePhoneVariable(phoneVariable);
//        orderDetailResponse.setOrderResponse(orderResponse);
//        return orderDetailResponse;
    }
}
