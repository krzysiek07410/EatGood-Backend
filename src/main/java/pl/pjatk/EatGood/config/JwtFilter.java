package pl.pjatk.EatGood.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.hibernate.annotations.Filter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.pjatk.EatGood.domain.User;
import pl.pjatk.EatGood.exceptionshandlers.TokenException;
import pl.pjatk.EatGood.exceptionshandlers.TokenHeaderException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

public class JwtFilter implements javax.servlet.Filter {

    @Value("${signing.key}")
    private String signingKey;

    public JwtFilter(String signingKey) {
        this.signingKey = signingKey;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String headerToken = httpServletRequest.getHeader("Authorization");
        String headerUsername = httpServletRequest.getHeader("Username");

        if (!Objects.equals(httpServletRequest.getMethod(), "OPTIONS")) {
            if (headerToken == null || !headerToken.startsWith("Bearer ")) {
                throw new TokenHeaderException();
            } else {
                try {
                    String token = headerToken.substring(7);
                    Claims claims = Jwts.parser().setSigningKey((headerUsername + signingKey).getBytes())
                            .parseClaimsJws(token).getBody();
                    servletRequest.setAttribute("claims", claims);
                } catch (final SignatureException e) {
                    throw new TokenException();
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}