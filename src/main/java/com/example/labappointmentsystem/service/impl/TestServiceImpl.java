package com.example.labappointmentsystem.service.impl;

import com.example.labappointmentsystem.dto.TestDto;
import com.example.labappointmentsystem.entity.Test;
import com.example.labappointmentsystem.repository.TestRepository;
import com.example.labappointmentsystem.service.TestService;

import java.util.List;

public class TestServiceImpl implements TestService {
    TestRepository testRepository;

    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    /**
     * @param testDto
     */
    @Override
    public void saveTest(TestDto testDto) {
        Test test = new Test();
        test.setTestName(testDto.getTestName());
        test.setOperatorId(testDto.getOperatorId());

        testRepository.save(test);
    }

    /**
     * @param email
     * @return
     */
    @Override
    public Test findByOperatorId(String email) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<TestDto> findAllTests() {
        return null;
    }
}
