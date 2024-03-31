package com.example.labappointmentsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
    @Column(name = "address1")
    private String address1;

    @Size(max = 255)
    @Column(name = "address2")
    private String address2;

    @Size(max = 255)
    @Column(name = "city")
    private String city;

    @Size(max = 40)
    @Column(name = "patient_id", length = 40)
    private String patientId;

//    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
//    @JoinTable(
//            name = "appointments",
//            joinColumns = @JoinColumn(name = "id"),
//            inverseJoinColumns = @JoinColumn(name = "patient_id")
//    )
//    private List<Appointment> appointments = new ArrayList<Appointment>();

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Appointment> appointments = new ArrayList<>();
}