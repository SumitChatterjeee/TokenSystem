package com.tokenSystem.repos;

import com.tokenSystem.entities.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClinicRepo extends JpaRepository<Clinic,Long> {

    public Optional<Clinic> findById(Long id);
}
