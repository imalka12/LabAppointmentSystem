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
public class TestDto {
    private Long id;
    @NotEmpty
    private String testName;
    @NotEmpty
    private Long operatorId;

    private String description;
    private Double amount;
    private Long status;
}
