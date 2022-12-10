package pl.pjatk.EatGood.ldap;

import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

public class LdapClient {

    private final LdapContextSource contextSource;
    private final LdapTemplate ldapTemplate;

    public LdapClient(LdapContextSource contextSource, LdapTemplate ldapTemplate) {
        this.contextSource = contextSource;
        this.ldapTemplate = ldapTemplate;
    }

    public void authenticate(final String username, final String password) {
        contextSource.getContext("cn=" + username + ",ou=Users,dc=eatgood,dc=local", password);
    }

}
