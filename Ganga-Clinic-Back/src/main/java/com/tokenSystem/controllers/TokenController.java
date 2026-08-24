package com.tokenSystem.controllers;

import com.tokenSystem.dto.TokenRequest;
import com.tokenSystem.dto.TokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TokenController {

    @GetMapping("/getToken")
    public ResponseEntity<TokenResponse> getToke(@RequestBody TokenRequest tokenRequest){

    }
}
