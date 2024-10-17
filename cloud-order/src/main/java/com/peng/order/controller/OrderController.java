package com.peng.order.controller;


import com.peng.order.entity.Order;
import com.peng.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "{orderId}")
    public Order findOrderByOrderId(@PathVariable("orderId") Long orderId ) {
        System.out.println("called");
        return orderService.findOrderByOrderId(orderId);
    }


}


