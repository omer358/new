package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.websocket.server.PathParam;


@Controller
@RequestMapping
public class SocialLoginController {
    @GetMapping
    public String getHomePage() {
        return "index";
    }

    @GetMapping(path = "/code/linkedin")
    public String verfiyAccess(@PathVariable String code,@PathVariable String status) {

        return "linkedIn";
    }
}
