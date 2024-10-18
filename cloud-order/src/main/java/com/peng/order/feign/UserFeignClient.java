package com.peng.order.feign;
import com.peng.order.config.DefaultFeignConfiguration;
import com.peng.order.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(value = "cloud-user", configuration = DefaultFeignConfiguration.class)
public interface UserFeignClient {

    @GetMapping("/api/user/{userId}")
    User getUserByUserId( @PathVariable Long userId ) ;



}







