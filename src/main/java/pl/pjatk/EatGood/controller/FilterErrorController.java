package pl.pjatk.EatGood.controller;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.pjatk.EatGood.exceptionshandlers.TokenException;
import pl.pjatk.EatGood.exceptionshandlers.TokenExpiredException;
import pl.pjatk.EatGood.exceptionshandlers.TokenHeaderException;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
public class FilterErrorController implements ErrorController {
    @RequestMapping("/error")
    public void handleError(HttpServletRequest request) throws Throwable {
        String exceptionString = request.getAttribute("javax.servlet.error.exception").toString();
        if (exceptionString.equals("pl.pjatk.EatGood.exceptionshandlers.TokenHeaderException")) {
            throw new TokenHeaderException();
        } else if (exceptionString.contains("io.jsonwebtoken.ExpiredJwtException")) {
            throw new TokenExpiredException();
        } else if (exceptionString.equals("pl.pjatk.EatGood.exceptionshandlers.TokenException") ||
                exceptionString.contains("JwtException")) {
            throw new TokenException();
        }
    }
}