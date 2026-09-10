package com.tokenSystem.repos;

import com.tokenSystem.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface TokenRepo extends JpaRepository<Token,Long> {

    @Query(value = """
            SELECT *
            FROM tokens
            WHERE clinic_id = :clinicId
              AND queue_date = :queueDate
            ORDER BY token_number DESC
            LIMIT 1
            """, nativeQuery = true)
    Optional<Token> findLastToken(
            @Param("clinicId") Long clinicId,
            @Param("queueDate") LocalDate queueDate
    );
}
