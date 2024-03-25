package com.example.labappointmentsystem.controller;

import com.example.labappointmentsystem.dto.PatientDto;
import com.example.labappointmentsystem.entity.Patient;
import com.example.labappointmentsystem.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PatientController {
    private PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping("/patient")
    public String home(Model model){
        PatientDto patient = new PatientDto();
        model.addAttribute("patient", patient);
        return "patient-registration";
    }

    @RequestMapping(value="/patient/save", method= RequestMethod.POST)
    public String savePatient(Model model, @ModelAttribute("patient") Patient patient) {
        PatientDto patientDto = new PatientDto();
        patientDto.setFirstName(patient.getFirstName());
        patientDto.setLastName(patient.getLastName());
        patientDto.setEmail(patient.getEmail());
        patientDto.setTelephone(patient.getTelephone());
        patientDto.setAddress(patient.getAddress());
        patientDto.setPatientId(patient.getPatientId());
        patientService.savePatient(patientDto);

        return "redirect:/test?name=" + patient.getFirstName() + "&lastname=" + patient.getLastName();
    }
}
