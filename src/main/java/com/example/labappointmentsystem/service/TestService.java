package com.example.labappointmentsystem.service;

import com.example.labappointmentsystem.dto.TestDto;
import com.example.labappointmentsystem.entity.Test;

import java.util.List;

public interface TestService {
    void saveTest(TestDto testDto);

    Test findByOperatorId(String email);

    List<TestDto> findAllTests();
}
