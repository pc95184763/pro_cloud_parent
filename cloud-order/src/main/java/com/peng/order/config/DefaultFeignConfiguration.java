package com.peng.order.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class DefaultFeignConfiguration {

    @Bean
    public Logger.Level feighLogLevel() {
        return Logger.Level.BASIC;
    }

}
