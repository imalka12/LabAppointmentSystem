package com.example.labappointmentsystem.controller;

import com.example.labappointmentsystem.dto.TestDto;
import com.example.labappointmentsystem.entity.Test;
import com.example.labappointmentsystem.service.TestService;
import com.example.labappointmentsystem.service.impl.TestServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

    private TestService testService;

    public TestController(TestService testService){
        this.testService = testService;
    }

    @GetMapping("/test")
    public String home(Model model){
        TestDto test = new TestDto();
        model.addAttribute("test", test);
        return "create-test";
    }

    @RequestMapping(value="/test/save", method= RequestMethod.POST)
    public String saveTest(Model model, @ModelAttribute("test") Test test) {
        TestDto testDto = new TestDto();
        testDto.setTestName(test.getTestName());
        testDto.setOperatorId(test.getOperatorId());
        testService.saveTest(testDto);

        return "redirect:/test?name=" + test.getTestName() + "&operatorId=" + test.getOperatorId();
    }
}
