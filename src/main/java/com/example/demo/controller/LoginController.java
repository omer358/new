package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login/oauth2/code/linkedin")
    public String handleOAuth2Callback(OAuth2AuthenticationToken token) {
        long id = 0;
        String firstName = token.getPrincipal().getAttribute("firstName");
        String lastName = token.getPrincipal().getAttribute("lastName");
        String email = token.getPrincipal().getAttribute("email-address");

        User user = new User(id,firstName,lastName,email);
        userService.saveUser(user);

        return "User data saved successfully!";
    }

}