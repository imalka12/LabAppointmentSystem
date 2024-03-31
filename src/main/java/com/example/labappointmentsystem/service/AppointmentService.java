package com.example.labappointmentsystem.service;

import com.example.labappointmentsystem.dto.AppointmentDto;
import com.example.labappointmentsystem.dto.TestDto;
import com.example.labappointmentsystem.entity.Appointment;
import com.example.labappointmentsystem.entity.User;

import java.util.List;

public interface AppointmentService {
    void saveAppointment(AppointmentDto appointmentDto);

    List<AppointmentDto> findAllAppointments();

    AppointmentDto findAppointmentById(Long id);
}
