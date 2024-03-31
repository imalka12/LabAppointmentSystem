package com.example.labappointmentsystem.service.impl;

import com.example.labappointmentsystem.dto.AppointmentDto;
import com.example.labappointmentsystem.entity.Appointment;
import com.example.labappointmentsystem.entity.User;
import com.example.labappointmentsystem.repository.AppointmentRepository;
import com.example.labappointmentsystem.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        Appointment appointment = new Appointment();
        appointment.setDoctorName(appointmentDto.getDoctorName());
        appointment.setAppointmentTime(appointmentDto.getAppointmentTime());
        appointment.setAppointmentDate(appointmentDto.getAppointmentDate());
        appointment.setAppointmentNumber(appointmentDto.getAppointmentNumber());
        appointment.setStatus(appointmentDto.getStatus());
        appointmentRepository.save(appointment);
    }

    @Override
    public List<AppointmentDto> findAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return  appointments.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    private AppointmentDto convertEntityToDto(Appointment appointment){
        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setAppointmentDate(appointment.getAppointmentDate());
        appointmentDto.setAppointmentTime(appointment.getAppointmentTime());
        appointmentDto.setDoctorName(appointment.getDoctorName());
        appointmentDto.setStatus(appointment.getStatus());
        appointmentDto.setAppointmentNumber(appointment.getAppointmentNumber());
        return appointmentDto;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public AppointmentDto findAppointmentById(Long id) {
        System.err.println("received id :" + id);
        Appointment appointment = appointmentRepository.getReferenceById(id);
        return convertEntityToDto(appointment);
    }

    private List<AppointmentDto> convertToDtoList(List<Appointment> appointments) {
        return appointments.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
}
