package pl.pjatk.EatGood.ldap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
public class LdapConfig {

    // to be changed as env
    @Bean
    public LdapContextSource contextSource() {
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl("ldap://172.17.100.151:389/");
        contextSource.setBase("ou=Users,dc=eatgood,dc=local");
        contextSource.setUserDn("cn=s00001");
        contextSource.setPassword("asdasd");
        return contextSource;
    }

    @Bean
    public LdapTemplate ldapTemplate() {
        return new LdapTemplate(contextSource());
    }

    @Bean
    public LdapClient ldapClient() {
        return new LdapClient(contextSource(), ldapTemplate());
    }
}
