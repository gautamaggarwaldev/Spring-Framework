package in.ggklass.filterDemoTwo.configuration;

import in.ggklass.filterDemoTwo.filters.DummyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<DummyFilter> getDummyFilterBean() {
        FilterRegistrationBean<DummyFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new DummyFilter());

//        registrationBean.setOrder(2);

        registrationBean.addUrlPatterns("/api/*, /admin/*");
        return registrationBean;
    }
}
