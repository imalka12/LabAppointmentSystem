package com.example.labappointmentsystem.service.impl;

import com.example.labappointmentsystem.dto.TestDto;
import com.example.labappointmentsystem.entity.Test;
import com.example.labappointmentsystem.repository.TestRepository;
import com.example.labappointmentsystem.service.TestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestServiceImpl implements TestService {
    private TestRepository testRepository;

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
        test.setDescription(testDto.getDescription());
        test.setStatus(testDto.getStatus());
        test.setAmount(testDto.getAmount());
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
    public List<TestDto> findeAlltests() {
        List<Test> tests = testRepository.findAll();
        return  tests.stream().map((test) -> convertEntityToDto(test)).collect(Collectors.toList());
    }

    private TestDto convertEntityToDto(Test test){
        TestDto testDto = new TestDto();
        testDto.setTestName(test.getTestName());
        testDto.setOperatorId(test.getOperatorId());
        testDto.setDescription(test.getDescription());
        testDto.setStatus(test.getStatus());
        testDto.setAmount(testDto.getAmount());
        return testDto;
    }

}
