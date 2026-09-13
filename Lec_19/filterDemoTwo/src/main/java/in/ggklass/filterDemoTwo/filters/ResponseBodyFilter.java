package in.ggklass.filterDemoTwo.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

//@Component
public class ResponseBodyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        ContentCachingResponseWrapper wrapperResponse = new ContentCachingResponseWrapper(httpServletResponse);

        chain.doFilter(request, wrapperResponse);

        byte[] originalBodayBytes = wrapperResponse.getContentAsByteArray();

        String originalBody = new String(originalBodayBytes);

        String modifiedBody = """
                    {
                    "originalBody": %s,
                    "appName": "Student Management System"
                    }
                """.formatted(originalBody);
        wrapperResponse.resetBuffer();
        wrapperResponse.getWriter().write(modifiedBody);
        wrapperResponse.copyBodyToResponse();
    }
}
