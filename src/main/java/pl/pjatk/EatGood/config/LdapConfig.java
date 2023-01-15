package pl.pjatk.EatGood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import pl.pjatk.EatGood.service.LdapService;

@Configuration
public class LdapConfig {

    // to be changed as env
    @Bean
    public LdapContextSource contextSource() {
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl("ldap://172.19.3.68:389/");
        contextSource.setBase("ou=Users,dc=eatgood,dc=local");
        return contextSource;
    }

    @Bean
    public LdapTemplate ldapTemplate() {
        return new LdapTemplate(contextSource());
    }

    @Bean
    public LdapService ldapClient() {
        return new LdapService(contextSource(), ldapTemplate());
    }


}
