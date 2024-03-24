package com.example.labappointmentsystem.repository;

import com.example.labappointmentsystem.entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicianRepository extends JpaRepository<Technician, Long> {
}
