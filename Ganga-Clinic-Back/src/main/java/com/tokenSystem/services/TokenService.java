package com.tokenSystem.services;

import com.tokenSystem.dto.TokenRequest;
import com.tokenSystem.dto.TokenResponse;
import com.tokenSystem.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final UserRepo userRepo;

    public TokenResponse getToken(TokenRequest tokenRequest){
        String name=tokenRequest.name();
        Long clinicId=tokenRequest.clinicId();

    }
}
