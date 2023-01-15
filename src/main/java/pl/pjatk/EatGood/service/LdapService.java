package pl.pjatk.EatGood.service;

import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

public class LdapService {

    private final LdapContextSource contextSource;
    private final LdapTemplate ldapTemplate;

    public LdapService(LdapContextSource contextSource, LdapTemplate ldapTemplate) {
        this.contextSource = contextSource;
        this.ldapTemplate = ldapTemplate;
    }

    public void authenticate(final String username, final String password) {
        contextSource.getContext("cn=" + username + ",ou=Users,dc=eatgood,dc=local", password);
    }

}