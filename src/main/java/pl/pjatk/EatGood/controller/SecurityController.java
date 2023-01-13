package pl.pjatk.EatGood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class SecurityController {

//    @GetMapping("/")
//    public String index() {
//        return "index";
//    }

    @GetMapping("/")
    public String index() {
        return "Welcome to the home page!";
    }

    @GetMapping("/username")
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }

}
