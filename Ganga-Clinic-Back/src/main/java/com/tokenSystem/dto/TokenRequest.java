package com.tokenSystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record TokenRequest(

        @NotBlank(message = "Name is required") String name,
        @NotNull(message = "Clinic ID is required") Long clinicId) {
}
