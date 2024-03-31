package com.example.labappointmentsystem.service;

import com.example.labappointmentsystem.dto.PatientDto;
import com.example.labappointmentsystem.dto.TestDto;
import com.example.labappointmentsystem.entity.Patient;

import java.util.List;

public interface PatientService {
    void savePatient(PatientDto patientDto);

    List<PatientDto> findAllPatients();

    PatientDto getPatientById(Long id);
}
