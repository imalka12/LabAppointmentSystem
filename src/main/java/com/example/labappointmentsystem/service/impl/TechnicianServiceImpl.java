package com.example.labappointmentsystem.service.impl;

import com.example.labappointmentsystem.dto.TechnicianDto;
import com.example.labappointmentsystem.dto.TestDto;
import com.example.labappointmentsystem.entity.Technician;
import com.example.labappointmentsystem.entity.Test;
import com.example.labappointmentsystem.repository.TechnicianRepository;
import com.example.labappointmentsystem.service.TechnicianService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TechnicianServiceImpl implements TechnicianService {
    TechnicianRepository technicianRepository;

    public TechnicianServiceImpl(TechnicianRepository technicianRepository) {
        this.technicianRepository = technicianRepository;
    }

    /**
     * @param technicianDto
     */
    @Override
    public void saveTechnician(TechnicianDto technicianDto) {
        Technician technician = new Technician();
        technician.setName(technicianDto.getName());
        technician.setEmail(technicianDto.getEmail());
        technician.setAddress(technicianDto.getAddress());
        technician.setTelephone(technicianDto.getTelephone());

        technicianRepository.save(technician);
    }

    /**
     * @return
     */
    @Override
    public List<TechnicianDto> findAlltechnicians() {
        List<Technician> technicians = technicianRepository.findAll();
        return  technicians.stream().map((technician) -> convertEntityToDto(technician)).collect(Collectors.toList());
    }

    private TechnicianDto convertEntityToDto(Technician technician){
        TechnicianDto technicianDto = new TechnicianDto();
        technicianDto.setName(technician.getName());
        technicianDto.setEmail(technician.getEmail());
        technicianDto.setAddress(technician.getAddress());
        technicianDto.setTelephone(technician.getTelephone());
        return technicianDto;
    }
}
