package com.restaurantsystem.hosptialapi.repository;

import com.restaurantsystem.hosptialapi.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
