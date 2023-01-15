package pl.pjatk.EatGood.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.EatGood.domain.User;
import pl.pjatk.EatGood.service.LdapService;

import java.util.Date;

@RestController
@RequestMapping("/")
public class LdapController {

    @Value("${signing.key}")
    private String signingKey;

    private final LdapService ldapService;

    public LdapController(LdapService ldapService) {
        this.ldapService = ldapService;
    }

    @PostMapping("/log")
    public String login(@RequestBody User user) {
        ldapService.authenticate(user.getUsername(), user.getPassword());
        long currentTimeMillis = System.currentTimeMillis();
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("roles","user")
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + 1800000))
                .signWith(SignatureAlgorithm.HS512, (user.getUsername() + signingKey).getBytes())
                .compact();
    }
}