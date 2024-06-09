package com.restaurantsystem.hosptialapi.repository;

import com.restaurantsystem.hosptialapi.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
}
