package pl.pjatk.EatGood.controller;

import io.jsonwebtoken.ExpiredJwtException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.pjatk.EatGood.exceptionshandlers.TokenException;
import pl.pjatk.EatGood.exceptionshandlers.TokenExpiredException;
import pl.pjatk.EatGood.exceptionshandlers.TokenHeaderException;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Api(value = "Error Controller", description = "Error Controller that handles exceptions")
@Controller
public class FilterErrorController implements ErrorController {
    @RequestMapping("/error")
    @ApiOperation(
            value = "Exception  handler",
            notes = "Handles exceptions",
            response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public void handleError(HttpServletRequest request) throws Throwable {
        String exceptionString = new String();
        if (request.getAttribute("javax.servlet.error.exception") != null) {
            exceptionString = request.getAttribute("javax.servlet.error.exception").toString();
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
}