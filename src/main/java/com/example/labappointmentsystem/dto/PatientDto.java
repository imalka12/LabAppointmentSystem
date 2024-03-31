package com.example.labappointmentsystem.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {
    private Long id;
    @NotEmpty
    private String firstName;
    private String lastName;
    private String email;
    @NotEmpty
    private String telephone;
    private String address1;
    private String address2;
    private String city;
    private String patientId;
}
