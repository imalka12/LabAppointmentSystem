package com.example.labappointmentsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "appointment_tests")
public class AppointmentTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "appointment_id", nullable = false)
    private Long appointmentId;

    @NotNull
    @Column(name = "test_id", nullable = false)
    private Long testId;

    @Column(name = "status")
    private Integer status;

}