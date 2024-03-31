package com.example.labappointmentsystem.controller;

import com.example.labappointmentsystem.dto.TechnicianDto;
import com.example.labappointmentsystem.dto.TestDto;
import com.example.labappointmentsystem.entity.Technician;
import com.example.labappointmentsystem.service.TechnicianService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TechnicianController {
    private final TechnicianService technicianService;

    public TechnicianController(TechnicianService technicianService){
        this.technicianService = technicianService;
    }

    @GetMapping("/technician")
    public String home(Model model){
        TechnicianDto technician = new TechnicianDto();
        model.addAttribute("technician", technician);
        return "create-technician";
    }

    @RequestMapping(value="/technician/save", method= RequestMethod.POST)
    public String saveTechnician(Model model, @ModelAttribute("technician") Technician technician) {
        TechnicianDto technicianDto = new TechnicianDto();
        technicianDto.setName(technician.getName());
        technicianDto.setEmail(technician.getEmail());
        technicianDto.setAddress(technician.getAddress());
        technicianDto.setTelephone(technician.getTelephone());
        technicianService.saveTechnician(technicianDto);

        return "redirect:/technician?name=" + technician.getName();
    }

    @GetMapping("/create-technician")
    public String listTechnicians(Model model){
        List<TechnicianDto> technicians = technicianService.findAlltechnicians();
        model.addAttribute("technicians", technicians);
        return "create-technician";
    }
}
