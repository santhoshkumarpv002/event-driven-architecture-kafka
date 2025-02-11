package com.example.order_service.controller;

import java.util.UUID;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Order;
import com.example.dto.OrderEvent;
import com.example.order_service.service.OrderProducer;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class OrderController {
    

private OrderProducer orderProducer;

@PostMapping("/order")
public String makeOrder(@RequestBody Order order) {
    

    order.setId(UUID.randomUUID().toString());
OrderEvent orderevent=new OrderEvent();
orderevent.setOrder(order);
orderevent.setOrderStatus("PENDING");
orderevent.setMessage("Order in pending status");

    orderProducer.orderProducer(orderevent);
    
    return "your order placed successfully";
}



}
