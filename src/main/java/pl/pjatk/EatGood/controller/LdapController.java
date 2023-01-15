package pl.pjatk.EatGood.controller;

import pl.pjatk.EatGood.domain.User;
import pl.pjatk.EatGood.service.LdapService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/")
public class LdapController {


    private final LdapService ldapService;
    private final User currentUser;

    public LdapController(LdapService ldapService, User currentUser) {
        this.ldapService = ldapService;
        this.currentUser = currentUser;
    }

    @PostMapping("/log")
    public String login(@RequestBody User user) {
        ldapService.authenticate(user.getUsername(), user.getPassword());
        long currentTimeMillis = System.currentTimeMillis();
        currentUser.setUsername(user.getUsername());
        currentUser.setPassword(user.getPassword());
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("roles","user")
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + 900000))
                .signWith(SignatureAlgorithm.HS512, user.getPassword())
                .compact();
    }

}
