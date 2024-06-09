package com.restaurantsystem.hosptialapi.controllers;


import com.restaurantsystem.hosptialapi.models.Staff;
import com.restaurantsystem.hosptialapi.repository.StaffRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/staff")
@AllArgsConstructor
public class StaffController {

    private final StaffRepository staffRepository;

    @GetMapping
    public ResponseEntity<List<Staff>> getAllStaff(){
        List<Staff> staffList = staffRepository.findAll();
        return ResponseEntity.ok(staffList);
    }
}
