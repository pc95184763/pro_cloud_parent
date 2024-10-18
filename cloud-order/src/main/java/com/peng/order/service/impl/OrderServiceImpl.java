package com.peng.order.service.impl;

import com.peng.order.entity.Order;
import com.peng.order.entity.User;
import com.peng.order.feign.UserFeignClient;
import com.peng.order.mapper.OrderMapper;
import com.peng.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    public Order findOrderByOrderId(Long orderId) {

        Order order = orderMapper.findOrderByOrderId( orderId );
//      System.out.println( order );

//      ServiceInstance serviceInstance = chooseServiceInstance("cloud-user");
//      System.out.println("http://" + serviceInstance.getHost()+":"+serviceInstance.getPort() );

//        User user = restTemplate.getForObject( "http://cloud-user/api/user/" + order.getUserId()  , User.class);

        User user = userFeignClient.getUserByUserId( order.getUserId() );

        System.out.println( user );
        order.setUser(user);

        return order;
    }




    public ServiceInstance chooseServiceInstance(String applicationName) {
        List<ServiceInstance> instances = discoveryClient.getInstances(applicationName);
        int size = instances.size();
        Random rand = new Random();
        int idx = rand.nextInt(size);
        ServiceInstance instance = instances.get(idx);

        return instance;
    }


}







