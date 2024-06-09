package com.restaurantsystem.hosptialapi.repository;

import com.restaurantsystem.hosptialapi.models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Long> {
}
