package com.example.demo.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.model.UserInfo;

@Controller
@RequestMapping
public class Linkedin {
    @GetMapping("auth/linkeddin")
    public Map<String ,Object>UserDetails(@AuthenticationPrincipal OAuth2User  user){
        return user.getAttributes();
    }
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping(value = "/template/products", method = RequestMethod.POST)
    public String createProducts(@RequestBody UserInfo product) {
       HttpHeaders headers = new HttpHeaders();
       headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
       HttpEntity<UserInfo> entity = new HttpEntity<UserInfo>(product,headers);
       
       return restTemplate.exchange(
          "https://api.linkedin.com/v2/me", HttpMethod.POST, entity, String.class).getBody();
    }
    @Component
    public class FeignClientInterceptor implements RequestInterceptor {
    
      private static final String AUTHORIZATION_HEADER = "Authorization";

      public static String getBearerTokenHeader() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
      }
    
      @Override
      public void apply(requestTemplate requestTemplate) {

          requestTemplate.header(AUTHORIZATION_HEADER, getBearerTokenHeader());
       
      }
    }
}

