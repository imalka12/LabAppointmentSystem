package com.example.labappointmentsystem.repository;

import com.example.labappointmentsystem.entity.Appointment;
import com.example.labappointmentsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
