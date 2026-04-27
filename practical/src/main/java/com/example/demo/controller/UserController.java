package com.example.demo.controller;

import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	  @GetMapping("/profile")
	    public Map<String, Object> getProfile(@AuthenticationPrincipal OAuth2User  user) {

	        if (user == null) {
	            return Map.of("error", "User not authenticated");
	        }

	        String name = user.getAttribute("name");
	        String email = user.getAttribute("email");

	        return Map.of(
	                "name", name,
	                "email", email
	        );
	    }
}
