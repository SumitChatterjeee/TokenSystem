package com.tokenSystem.services;

import com.tokenSystem.dto.TokenRequest;
import com.tokenSystem.dto.TokenResponse;
import com.tokenSystem.entities.Clinic;
import com.tokenSystem.entities.Patient;
import com.tokenSystem.entities.Token;
import com.tokenSystem.enums.Status;
import com.tokenSystem.repos.ClinicQueueCounterRepo;
import com.tokenSystem.repos.ClinicRepo;
import com.tokenSystem.repos.PatientRepo;
import com.tokenSystem.repos.TokenRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final ClinicRepo clinicRepo;

    private final TokenRepo tokenRepo;

    private final ClinicQueueCounterRepo clinicQueueCounterRepo;

    private final PatientRepo patientRepo;

    public TokenResponse getToken(TokenRequest tokenRequest){
        String name=tokenRequest.name();
        Long clinicId=tokenRequest.clinicId();
        Clinic clinic = clinicRepo.findById(clinicId)
                .orElseThrow(() -> new RuntimeException("Clinic not found"));

        LocalDate today = LocalDate.now();

        Long nextToken = clinicQueueCounterRepo.getNextToken(clinicId,today);

        Patient p=Patient.builder().
                patientName(name)
                        .status(Status.QUEUED).build();

        Patient p2=patientRepo.save(p);
        Token token=Token.builder()
                .tokenNumber(nextToken)
                .clinic(clinic)
                .patient(p2)
                .queueDate(today)
                .build();

        Token t=tokenRepo.save(token);
        TokenResponse tokenResponse=new TokenResponse(t.getTokenNumber(),t.getPatient().getPatientName());
        return tokenResponse;
    }
}
