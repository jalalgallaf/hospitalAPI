package com.restaurantsystem.hosptialapi.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    long staffId;

    @Column(name = "first_name")
    @Nonnull
    String firstName;
    @Nonnull
    @Column(name = "last_name")
    String lastName;
    @Column(name="role")
    @Nonnull
    String role;
    @Column(name = "contact_number")
    String contact_number;
    @Column(name="email")
    String email;

    @Column(name="department")
    String department;

    @Column(name="created_at")
    LocalDateTime created_at;

    @Column(name="updated_at")
    LocalDateTime updated_at;

    @OneToOne(mappedBy = "staff",cascade = CascadeType.ALL)
    @JoinColumn(name = "appointment_id")
    Appointment appointment;


    @PrePersist
    protected void onCreate(){
        this.created_at=LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updated_at=LocalDateTime.now();
    }
}