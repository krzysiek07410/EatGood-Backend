package pl.pjatk.EatGood.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.pjatk.EatGood.domain.User;

import java.util.Collections;

@Configuration
public class JwtFilterConfig {

    private final User currentUser;

    public JwtFilterConfig(User currentUser) {
        this.currentUser = currentUser;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new JwtFilter(currentUser));
        filterRegistrationBean.setUrlPatterns(Collections.singleton("/api/*"));
        return filterRegistrationBean;
    }
}