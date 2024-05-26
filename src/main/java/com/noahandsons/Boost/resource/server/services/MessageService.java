package com.noahandsons.Boost.resource.server.services;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MessageService {

    @PreAuthorize("hasAuthority('read')")
    public Map<String, String> welcomeMessage(@AuthenticationPrincipal Jwt user){
       return Map.of("message", "Hello " + user.getSubject());
    }
}
