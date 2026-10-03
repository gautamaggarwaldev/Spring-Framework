package in.ggklass.api_gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {

    private  Validator validator;
    private JwtUtil jwtUtil;

    public AuthFilter(Validator validator, JwtUtil jwtUtil) {
        super(Config.class);
        this.validator = validator;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public GatewayFilter apply(Config config) {

        return (exchange, chain) -> {

            // Check whether authentication is required
            if (validator.predicate.test(exchange.getRequest())) {

                // Get Authorization header
                String authHeader = exchange.getRequest()
                        .getHeaders()
                        .getFirst(HttpHeaders.AUTHORIZATION);

                // Check if Authorization header is missing
                if (authHeader == null || authHeader.isBlank()) {
                    throw new RuntimeException(
                            "Authorization header is missing"
                    );
                }

                // Check Bearer token
                if (!authHeader.startsWith("Bearer ")) {
                    throw new RuntimeException(
                            "Invalid Authorization header"
                    );
                }

                // Extract token
                String token = authHeader.substring(7);

                try {
                    jwtUtil.validateToken(token);
                } catch (Exception e) {
                    throw new RuntimeException(
                            "Invalid token"
                    );
                }
            }

            return chain.filter(exchange);
        };
    }

    public static class Config {
    }
}