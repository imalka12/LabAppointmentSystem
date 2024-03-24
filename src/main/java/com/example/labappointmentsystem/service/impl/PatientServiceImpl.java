package com.example.labappointmentsystem.service.impl;

import com.example.labappointmentsystem.dto.PatientDto;
import com.example.labappointmentsystem.entity.Patient;
import com.example.labappointmentsystem.repository.PatientRepository;
import com.example.labappointmentsystem.service.PatientService;

public class PatientServiceImpl implements PatientService {
    PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    /**
     * @param patientDto
     */
    @Override
    public void savePatient(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setFirstName(patientDto.getFirstName());
        patient.setLastName(patientDto.getLastName());
        patient.setTelephone(patientDto.getTelephone());
        patient.setEmail(patientDto.getEmail());
        patient.setAddress(patientDto.getAddress());
        patient.setPatientId(patientDto.getPatientId());
        patientRepository.save(patient);
    }
}
