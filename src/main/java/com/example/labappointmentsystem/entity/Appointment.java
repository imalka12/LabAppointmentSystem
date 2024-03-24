package com.example.labappointmentsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "patient_id", nullable = false)
    private Long patientId;

    @NotNull
    @Column(name = "appointment_date", nullable = false)
    private LocalDate appointmentDate;

    @NotNull
    @Column(name = "appointment_time", nullable = false)
    private LocalTime appointmentTime;

    @Size(max = 10)
    @Column(name = "appointment_number", length = 10)
    private String appointmentNumber;

    @Column(name = "status")
    private Integer status;

    @Size(max = 255)
    @NotNull
    @Column(name = "doctor_name", nullable = false)
    private String doctorName;

}