package pl.pjatk.EatGood.exceptionshandlers;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.net.ConnectException;

@RestControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<String> notFound(HttpClientErrorException.NotFound exception) {
        return ResponseEntity.status(404).body("NOT FOUND" + exception.getLocalizedMessage());
    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<String> badRequest(HttpClientErrorException.BadRequest exception) {
        return ResponseEntity.status(400).body("BAD REQUEST" + exception.getLocalizedMessage());
    }

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<String> internalServerError(HttpServerErrorException.InternalServerError exception) {
        return ResponseEntity.status(502).body("INTERNAL SERVER ERROR" + exception.getLocalizedMessage());
    }

    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<String> connectException(ConnectException exception) {
        return ResponseEntity.status(504).body("CONNECT EXCEPTION" + exception.getLocalizedMessage());
    }

    @ExceptionHandler(NotFoundFavouriteRecipeException.class)
    public ResponseEntity<String> getFavouriteRecipeById() {
        return ResponseEntity.status(404).body("NOT FOUND");
    }

    @ExceptionHandler(NotFoundUserException.class)
    public ResponseEntity<String> getUserById() {
        return ResponseEntity.status(404).body("NOT FOUND");
    }

    @ExceptionHandler(LdapAuthenticationException.class)
    public ResponseEntity<String> login() {
        return ResponseEntity.status(401).body("LDAP INVALID CREDENTIALS");
    }

    @ExceptionHandler(TokenHeaderException.class)
    public ResponseEntity<String> doFilterTokenHeader() {
        return ResponseEntity.status(401).body("MISSING OR INVALID TOKEN HEADER");
    }

    @ExceptionHandler(TokenException.class)
    public ResponseEntity<String> doFilterToken() {
        return ResponseEntity.status(401).body("INVALID TOKEN");
    }

    @ExceptionHandler(TokenExpiredException.class)
    public ResponseEntity<String> doFilterTokenExpired() {
        return ResponseEntity.status(403).body("EXPIRED TOKEN");
    }

}
