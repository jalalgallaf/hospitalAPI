package com.restaurantsystem.hosptialapi.models;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="appointment_id")
    long appointmentID;
    @Column(name="patient_id")
    @ManyToOne(cascade = CascadeType.ALL)
    Patient patient;

    @Column(name="staff_id")
    @OneToOne(cascade = CascadeType.ALL)
    Appointment appointment;


    @Column(name="appointment_date")
    LocalDateTime appointmentDate;
    @Column(name="notes")
    String notes;
    @Column(name = "created_at")
    LocalDateTime createdAt;
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
}
