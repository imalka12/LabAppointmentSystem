package com.example.labappointmentsystem.controller;

import com.example.labappointmentsystem.dto.AppointmentDto;
import com.example.labappointmentsystem.dto.PatientDto;
import com.example.labappointmentsystem.dto.TestDto;
import com.example.labappointmentsystem.entity.Appointment;
import com.example.labappointmentsystem.service.AppointmentService;
import com.example.labappointmentsystem.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AppointmentController {
    private AppointmentService appointmentService;
    private PatientService patientService;

    public AppointmentController(AppointmentService appointmentService,
                                 PatientService patientService){
        this.appointmentService = appointmentService;
        this.patientService = patientService;
    }

    @GetMapping("/appointment")
    public String home(Model model){
        AppointmentDto appointment = new AppointmentDto();
        model.addAttribute("appointment", appointment);
        return "create-appointment";
    }

    @RequestMapping(value="/appointment/save", method= RequestMethod.POST)
    public String saveAppointment(Model model, @ModelAttribute("appointment") Appointment appointment) {
        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setDoctorName(appointment.getDoctorName());
        appointmentDto.setAppointmentDate(appointment.getAppointmentDate());
        appointmentDto.setAppointmentTime(appointment.getAppointmentTime());
        appointmentDto.setAppointmentNumber(appointment.getAppointmentNumber());
        appointmentDto.setStatus(appointment.getStatus());
        appointmentService.saveAppointment(appointmentDto);

        return "redirect:/appointment";
    }

    @GetMapping("/all-appointment")
    public String listAppointments(Model model){
        List<AppointmentDto> appointments = appointmentService.findAllAppointments();
        model.addAttribute("appointments", appointments);
        return "all-appointment";
    }

    @GetMapping("/appointment-details")
    public String viewAppointmentDetails(Model model, @RequestParam String id){
        System.err.println("id is " + id);
        AppointmentDto appointment = appointmentService.findAppointmentById(Long.valueOf(id));
        System.err.println("patient id is " + appointment.getPatientId());
        PatientDto patientById = patientService.getPatientById(appointment.getPatientId());
        model.addAttribute("appointment", appointment);
        model.addAttribute("patient", patientById);
        return "appointment-details";
    }
}
