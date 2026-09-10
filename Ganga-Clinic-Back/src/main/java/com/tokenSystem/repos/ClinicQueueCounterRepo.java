package com.tokenSystem.repos;

import com.tokenSystem.entities.ClinicQueueCounter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ClinicQueueCounterRepo
        extends JpaRepository<ClinicQueueCounter, Long> {

    @Query(value = """
            INSERT INTO clinic_queue_counter
                (clinic_id, queue_date, last_token)
            VALUES
                (:clinicId, :queueDate, 1)
            ON CONFLICT (clinic_id, queue_date)
            DO UPDATE
                SET last_token = clinic_queue_counter.last_token + 1
            RETURNING last_token
            """, nativeQuery = true)
    Long getNextToken(
            @Param("clinicId") Long clinicId,
            @Param("queueDate") LocalDate queueDate
    );
}
