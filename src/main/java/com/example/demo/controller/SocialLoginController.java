package com.example.demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping
public class  SocialLoginController {
    @GetMapping
    public String getHomePage() {
        return "index";
    }

    @GetMapping("/user/me")
    public Map<String, Object> userDetails(@AuthenticationPrincipal OAuth2User user) {
        return user.getAttributes();
    }
}
