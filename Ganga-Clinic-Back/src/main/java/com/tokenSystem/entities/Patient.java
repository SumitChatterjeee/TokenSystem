package com.tokenSystem.entities;


import com.tokenSystem.enums.Status;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Table(name = "patient")
@Builder
public class Patient {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long patientId;

    @Column(name = "patient_name")
    String patientName;

    @Enumerated(EnumType.STRING)
    Status status;
}
