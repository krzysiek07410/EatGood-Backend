package pl.pjatk.EatGood.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.EatGood.domain.User;
import pl.pjatk.EatGood.exceptionshandlers.LdapAuthenticationException;
import pl.pjatk.EatGood.service.LdapService;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;

@ApiIgnore
@Api(value = "Authentication controller", description = "Controller for authentication")
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
    @ApiOperation(
            value = "Authenticate user",
            notes = "Authenticate user with given username and password",
            response = Jwts.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Bad request", response = String.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = String.class)
    })
    public String login(@RequestBody User user) throws LdapAuthenticationException {
        try {
            ldapService.authenticate(user.getUsername(), user.getPassword());
            long currentTimeMillis = System.currentTimeMillis();
            return Jwts.builder()
                    .setSubject(user.getUsername())
                    .claim("roles", "user")
                    .setIssuedAt(new Date(currentTimeMillis))
                    .setExpiration(new Date(currentTimeMillis + 1800000))
                    .signWith(SignatureAlgorithm.HS512, (user.getUsername() + signingKey).getBytes())
                    .compact();
        } catch(Exception e) {
            throw new LdapAuthenticationException();
        }
    }
}