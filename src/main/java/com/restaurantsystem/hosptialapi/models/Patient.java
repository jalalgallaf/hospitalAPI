package com.restaurantsystem.hosptialapi.models;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    long patientID;
    @Column(name="first_name")
    String firstName;
    @Column(name="last_name")
    String lastName;
    @Column(name="date_of_birth")
    LocalDate DateOfBirth;
    @Column(name="gender")
    String gender;
    @Column(name="contact_number ")
    String phoneNumber;
    @Column(name="email")
    String email;
    @Column(name="address")
    String address;
    @Column(name="emergency_contact")
    String emergencyContact;
    @Column(updatable = false)
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    //relation
    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)
    @JoinColumn(name = "appointment_id")
    List<Appointment> appointment;

    // Auto operations
    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt= LocalDateTime.now();
    }
}
