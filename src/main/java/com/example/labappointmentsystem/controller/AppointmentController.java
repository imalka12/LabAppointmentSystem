package com.example.labappointmentsystem.controller;

import com.example.labappointmentsystem.dto.AppointmentDto;
import com.example.labappointmentsystem.entity.Appointment;
import com.example.labappointmentsystem.service.AppointmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppointmentController {
    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
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
//        appointmentDto.setPatientId(appointment.getPatientId());
        appointmentService.saveAppointment(appointmentDto);
//
        return "redirect:/appointment";
    }
}
