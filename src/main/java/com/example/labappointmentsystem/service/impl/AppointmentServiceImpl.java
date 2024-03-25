package com.example.labappointmentsystem.service.impl;

import com.example.labappointmentsystem.dto.AppointmentDto;
import com.example.labappointmentsystem.entity.Appointment;
import com.example.labappointmentsystem.repository.AppointmentRepository;
import com.example.labappointmentsystem.service.AppointmentService;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    /**
     * @param appointmentDto
     */
    @Override
    public void saveAppointment(AppointmentDto appointmentDto) {
//        Appointment appointment = new Appointment();
//        appointment.setPatientId(appointmentDto.getPatientId());
//        appointmentRepository.save(appointment);
    }
}
