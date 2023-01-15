package pl.pjatk.EatGood.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import pl.pjatk.EatGood.domain.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

public class JwtFilter implements javax.servlet.Filter {

    private final User currentUser;

    public JwtFilter(User currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String header = httpServletRequest.getHeader("authorization");

//        System.out.println(httpServletRequest.getMethod());
//        System.out.println(!Objects.equals(httpServletRequest.getMethod(), "OPTIONS"));
//
        if (!Objects.equals(httpServletRequest.getMethod(), "OPTIONS")) {
            if (header == null || !header.startsWith("Bearer ")) {
//                System.out.println(header);
                throw new ServletException("Missing or invalid Authorization header");
            } else {
//                System.out.println(header);
                try {
                    String token = header.substring(7);
                    Claims claims = Jwts.parser().setSigningKey(currentUser.getPassword()).parseClaimsJws(token).getBody();
                    servletRequest.setAttribute("claims", claims);
                } catch (final SignatureException e) {
                    throw new ServletException("Invalid token");
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}