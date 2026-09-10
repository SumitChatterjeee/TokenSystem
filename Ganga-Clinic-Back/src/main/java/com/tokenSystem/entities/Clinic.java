package com.tokenSystem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Clinic {

    @Id
    @Column(name = "clinic_id", nullable = false, unique = true)
    private Long clinicId;

    @Column(nullable = false)
    private String name;
}
