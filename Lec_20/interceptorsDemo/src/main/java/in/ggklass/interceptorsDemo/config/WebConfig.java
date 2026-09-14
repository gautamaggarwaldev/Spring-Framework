package in.ggklass.interceptorsDemo.config;

import in.ggklass.interceptorsDemo.interceptor.AuthenticationInterceptor;
import in.ggklass.interceptorsDemo.interceptor.AuthorizationInterceptor;
import in.ggklass.interceptorsDemo.interceptor.LoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private LoggingInterceptor loggingInterceptor;
    private AuthenticationInterceptor authenticationInterceptor;
    private AuthorizationInterceptor authorizationInterceptor;

    public WebConfig(LoggingInterceptor loggingInterceptor,
                     AuthenticationInterceptor authenticationInterceptor,
                     AuthorizationInterceptor authorizationInterceptor) {
        this.loggingInterceptor = loggingInterceptor;
        this.authenticationInterceptor = authenticationInterceptor;
        this.authorizationInterceptor = authorizationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor).addPathPatterns("/api/**")
                .excludePathPatterns("/api/auth/login", "/api/public/**").order(1);

        registry.addInterceptor(loggingInterceptor).order(3);

        registry.addInterceptor(authorizationInterceptor).order(2);

    }
}
