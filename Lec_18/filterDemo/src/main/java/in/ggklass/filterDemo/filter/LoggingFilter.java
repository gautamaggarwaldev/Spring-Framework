package in.ggklass.filterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.UUID;

@Component
@Order(2)
public class LoggingFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        long startTime = System.currentTimeMillis();

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String requestId = UUID.randomUUID().toString();

        httpServletResponse.setHeader("X-Request_ID ", requestId);

        System.out.println(httpServletRequest.getMethod() + " " + httpServletRequest.getRequestURI());

        try {

            chain.doFilter(request,response);
        }
        finally {
            long duration = System.currentTimeMillis() - startTime;

            System.out.println("Response status: " + httpServletResponse.getStatus());
            System.out.println("API Response time: " + duration);
        }
    }
}
