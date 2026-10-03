package in.ggklass.api_gateway.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.List;
import java.util.function.Predicate;

@Component
public class Validator {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    public static  final List<String> endpoints = List.of(
            "/register",
            "/token",
            "/validate-token/{token}"
    );

    public Predicate<ServerHttpRequest> predicate = serverHttpRequest -> {
        String requestPath = serverHttpRequest.getURI().getPath();
        return endpoints.stream()
                .noneMatch(uri -> antPathMatcher.match(uri, requestPath));
    };
}
