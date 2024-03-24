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
public class TechnicianDto {
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String telephone;
    private String email;
    private String address;
}
