package com.lokesh.gateway.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class AuthFilter implements GlobalFilter {

    // 🔥 SAME SECRET AS AUTH SERVICE
    private static final SecretKey key =
            Keys.hmacShaKeyFor("my-super-secret-key-my-super-secret-key".getBytes());

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String path = exchange.getRequest().getURI().getPath();

        // ✅ Skip auth endpoints
        if (path.startsWith("/api/auth")) {
            return chain.filter(exchange);
        }

        List<String> authHeaders = exchange.getRequest()
                .getHeaders()
                .get("Authorization");

        if (authHeaders == null || authHeaders.isEmpty()) {
            return onError(exchange, "Missing Authorization header", HttpStatus.UNAUTHORIZED);
        }

        String token = authHeaders.get(0);

        if (!token.startsWith("Bearer ")) {
            return onError(exchange, "Invalid Authorization format", HttpStatus.UNAUTHORIZED);
        }

        token = token.substring(7);

        try {
            // ✅ FIXED parser
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String username = claims.getSubject();
            System.out.println("Authenticated user: " + username);

        } catch (Exception e) {
            return onError(exchange, "Invalid or expired token", HttpStatus.UNAUTHORIZED);
        }

        return chain.filter(exchange);
    }

    private Mono<Void> onError(ServerWebExchange exchange, String err, HttpStatus status) {
        exchange.getResponse().setStatusCode(status);
        byte[] bytes = err.getBytes(StandardCharsets.UTF_8);

        return exchange.getResponse()
                .writeWith(Mono.just(exchange.getResponse()
                        .bufferFactory()
                        .wrap(bytes)));
    }
}