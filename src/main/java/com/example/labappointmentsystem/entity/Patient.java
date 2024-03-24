package com.example.labappointmentsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 255)
    @Column(name = "firstname")
    private String firstName;

    @Size(max = 255)
    @Column(name = "lastname")
    private String lastName;

    @Size(max = 255)
    @Column(name = "email")
    private String email;

    @Size(max = 15)
    @NotNull
    @Column(name = "telephone", nullable = false, length = 15)
    private String telephone;

    @Size(max = 255)
    @Column(name = "address")
    private String address;

    @Size(max = 40)
    @Column(name = "patient_id", length = 40)
    private String patientId;

}