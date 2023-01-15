package pl.pjatk.EatGood.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.pjatk.EatGood.domain.User;

import java.util.Collections;

@Configuration
public class JwtFilterConfig {

    @Value("${signing.key}")
    private String signingKey;

    public JwtFilterConfig(@Value("${signing.key}") String signingKey) {
        this.signingKey = signingKey;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new JwtFilter(signingKey));
        filterRegistrationBean.setUrlPatterns(Collections.singleton("/api/*"));
        return filterRegistrationBean;
    }
}