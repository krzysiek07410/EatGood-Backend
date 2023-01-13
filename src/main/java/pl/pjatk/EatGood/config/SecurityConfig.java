package pl.pjatk.EatGood.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .anyRequest()
                .permitAll()
                .and()
                .cors()
                .and()
                .csrf()
                .disable();
//                .authorizeHttpRequests()
//                .anyRequest()
//                .fullyAuthenticated()
//                .and()
//                .formLogin()
//                .defaultSuccessUrl("/index.html")
//                .and()
//                .sessionManagement()
//                .invalidSessionUrl("/")
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .deleteCookies("JSESSIONID")
//                .and()
//                .cors();

        return http.build();
    }

    // https://docs.spring.io/spring-security/site/docs/4.2.x/reference/html/cors.html
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(List.of("GET","POST"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

//    @Autowired
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .ldapAuthentication()
//                .userDnPatterns("cn={0},ou=Users")
//                .contextSource()
//                .url("ldap://localhost:8389/dc=eatgood,dc=local")
//                .and()
//                .passwordCompare()
////                .passwordEncoder(new BCryptPasswordEncoder())
//                .passwordAttribute("userPassword");
//    }
}