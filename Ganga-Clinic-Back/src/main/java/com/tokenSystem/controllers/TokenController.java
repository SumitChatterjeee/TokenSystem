package com.tokenSystem.controllers;

import com.tokenSystem.dto.TokenRequest;
import com.tokenSystem.dto.TokenResponse;
import com.tokenSystem.services.TokenService;
import com.tokenSystem.utils.TimeCheck;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TokenController {


    private final TimeCheck timeCheck;

    private final TokenService tokenService;


    @GetMapping("/getToken")
    public ResponseEntity<TokenResponse> getToke(@RequestBody TokenRequest tokenRequest){
        if (!timeCheck.registrationPossible(LocalDateTime.now())) {
            throw new RuntimeException("Token registration is currently closed");
        }
        return ResponseEntity.ok().body(tokenService.getToken(tokenRequest));
    }
}
