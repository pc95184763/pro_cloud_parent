package com.peng.cloud.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class MyGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if ( !StringUtils.hasText(username) ) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED );
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange) ;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
