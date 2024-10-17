package com.peng.order.mapper;

import com.peng.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    public abstract Order findOrderByOrderId(Long orderId);
}
