package com.example.labappointmentsystem.dto;

import com.example.labappointmentsystem.service.PatientService;
import com.example.labappointmentsystem.service.impl.PatientServiceImpl;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {
    private Long id;
    @NotEmpty
    private Long patientId;
    @NotEmpty
    private LocalDate appointmentDate;
    @NotEmpty
    private LocalTime appointmentTime;
    @NotEmpty
    private String appointmentNumber;
    @NotEmpty
    private Integer status;
    private String doctorName;
}
