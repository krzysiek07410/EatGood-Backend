package pl.pjatk.EatGood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.pjatk.EatGood.domain.User;

@Configuration
public class UserConfig {

    @Bean
    public static User currentUser() {
        return new User();
    }
}
