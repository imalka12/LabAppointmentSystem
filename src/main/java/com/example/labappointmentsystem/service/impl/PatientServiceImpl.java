package com.example.labappointmentsystem.service.impl;

import com.example.labappointmentsystem.dto.PatientDto;
import com.example.labappointmentsystem.entity.Patient;
import com.example.labappointmentsystem.repository.PatientRepository;
import com.example.labappointmentsystem.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository;

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
        patient.setAddress1(patientDto.getAddress1());
        patient.setAddress2(patientDto.getAddress2());
        patient.setCity(patientDto.getCity());
        patient.setPatientId(patientDto.getPatientId());
        patientRepository.save(patient);
    }

    /**
     * @return
     */
    @Override
    public List<PatientDto> findAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return  patients.stream().map((patient) -> convertEntityToDto(patient)).collect(Collectors.toList());
    }

    /**
     * @param id
     * @return
     */
    @Override
    public PatientDto getPatientById(Long id) {
        System.err.println("Patient id rec is :" + id);
       Patient patient = patientRepository.getReferenceById(id);
       return convertEntityToDto(patient);
    }

    private PatientDto convertEntityToDto(Patient patient){
        PatientDto patientDto = new PatientDto();
        patientDto.setFirstName(patient.getFirstName());
        patientDto.setLastName(patient.getLastName());
        patientDto.setAddress1(patient.getAddress1());
        patientDto.setAddress2(patient.getAddress2());
        patientDto.setEmail(patient.getEmail());
        patientDto.setTelephone(patient.getTelephone());
        patientDto.setCity(patient.getCity());
        patientDto.setPatientId(patient.getPatientId());
        return patientDto;
    }
}
