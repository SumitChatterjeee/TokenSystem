package com.tokenSystem.entities;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;


@Entity
@Table(
        name = "clinic_queue_counter",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames={"clinic_id","queue_date"}
                )
        }
)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClinicQueueCounter {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="clinic_id",nullable=false)
    private Clinic clinic;

    @Column(name="queue_date",nullable=false)
    private LocalDate queueDate;

    @Column(name="last_token",nullable=false)
    private Long lastToken;

}