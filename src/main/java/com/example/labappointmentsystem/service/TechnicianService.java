package com.example.labappointmentsystem.service;

import com.example.labappointmentsystem.dto.TechnicianDto;
import com.example.labappointmentsystem.dto.TestDto;

import java.util.List;

public interface TechnicianService {
    void saveTechnician(TechnicianDto technicianDto);

    List<TechnicianDto> findAlltechnicians();
}
