package com.example.labappointmentsystem.service.impl;

import com.example.labappointmentsystem.dto.TechnicianDto;
import com.example.labappointmentsystem.entity.Technician;
import com.example.labappointmentsystem.repository.TechnicianRepository;
import com.example.labappointmentsystem.service.TechnicianService;
import org.springframework.stereotype.Service;

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
}
