package com.example.demo.controller;

import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class Linkedin {
    @GetMapping("auth/linkeddin")
    public Map<String ,Object>UserDetails(@AuthenticationPrincipal OAuth2User  user){
        return user.getAttributes();
    }
    
}
