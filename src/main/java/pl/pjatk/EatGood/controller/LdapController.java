package pl.pjatk.EatGood.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.EatGood.ldap.LdapClient;
import pl.pjatk.EatGood.ldap.LdapConfig;

@RestController
@RequestMapping("/api/user")
public class LdapController {

    private final LdapClient ldapClient;

    public LdapController(LdapClient ldapClient) {
        this.ldapClient = ldapClient;
    }

    @RequestMapping("/log")
    public String index() {
        ldapClient.authenticate("s00001", "asdasd");
        return "Greetings from Spring Boot!";
    }
}
