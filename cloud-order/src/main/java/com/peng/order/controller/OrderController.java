package com.peng.order.controller;


import com.peng.order.entity.Order;
import com.peng.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "{orderId}")
    public Order findOrderByOrderId(@PathVariable("orderId") Long orderId, @RequestParam(value = "color",required = false) String col ) {
        System.out.println("默认过滤器： " + col);
//        System.out.println("called");
        return orderService.findOrderByOrderId(orderId);
    }

}


