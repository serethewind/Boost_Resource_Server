package com.noahandsons.Boost.resource.server.controllers;

import com.noahandsons.Boost.resource.server.services.MessageService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("welcome")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping("demo")
    public ResponseEntity<Map<String, String>> welcomeMessage(@AuthenticationPrincipal Jwt user){

                return ResponseEntity.ok(messageService.welcomeMessage(user));
    }
}
