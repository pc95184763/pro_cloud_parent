package com.peng.order.service;

import com.peng.order.entity.Order;

public interface OrderService {

    public abstract Order findOrderByOrderId(Long orderId);

}
