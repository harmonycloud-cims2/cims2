package com.harmonycloud.filter;

import com.harmonycloud.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

@Component
public class JwtTokenFilter implements GlobalFilter, Ordered{

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);
    private static final long REFRESH_TOKEN_TIME = 5 * 60 * 1000;
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        logger.info("I am In:{}，method:{}",request.getURI(),request.getMethod().toString());
        try {
            HttpHeaders headers = request.getHeaders();
            String token = jwtUtil.getToken(headers);
            ServerHttpResponse response = exchange.getResponse();
            if (!StringUtils.isEmpty(token)) {
                Map<String, Object> result = jwtUtil.validateToken(token);
                if ((boolean) result.get("access")) {
                    return chain.filter(exchange);
                } else {
                    logger.info("token is Invalid");
                    //token 是无效的
                    response.setStatusCode(HttpStatus.UNAUTHORIZED);
                    String msg = (String)result.get("errorMsg");
                    byte[] bytes = ("{\"msg\":"+msg+"}").getBytes(StandardCharsets.UTF_8);
                    DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
                    return response.writeWith(Flux.just(buffer));
                }
            }

        } catch (Exception e) {
            logger.info("error happened {}:",e);
            e.printStackTrace();

        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
