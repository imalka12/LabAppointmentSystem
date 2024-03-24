package com.example.labappointmentsystem.repository;

import com.example.labappointmentsystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
