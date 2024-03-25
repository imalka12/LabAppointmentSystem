package com.example.labappointmentsystem.controller;

import com.example.labappointmentsystem.dto.TestReportDto;
import com.example.labappointmentsystem.service.TestReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestReportController {
    private TestReportService testReportService;

    public TestReportController(TestReportService testReportService){
        this.testReportService = testReportService;
    }

    @GetMapping("/test-report")
    public String home(Model model){
        TestReportDto testReport = new TestReportDto();
        model.addAttribute("testReport", testReport);
        return "test-reports";
    }
}
