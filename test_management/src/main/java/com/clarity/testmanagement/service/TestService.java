package com.clarity.testmanagement.service;

import com.clarity.testmanagement.entity.Test;
import com.clarity.testmanagement.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    
    private final TestRepository testRepository;
    
    public List<Test> getAllTests() {
        return testRepository.findAll();
    }
    
    public Test getTestById(Long id) {
        return testRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test not found with id: " + id));
    }
    
    public Test createTest(Test test) {
        return testRepository.save(test);
    }
    
    public Test updateTest(Long id, Test testDetails) {
        Test test = getTestById(id);
        test.setName(testDetails.getName());
        test.setDescription(testDetails.getDescription());
        test.setStatus(testDetails.getStatus());
        return testRepository.save(test);
    }
    
    public void deleteTest(Long id) {
        testRepository.deleteById(id);
    }
    
    public List<Test> getTestsByStatus(Test.TestStatus status) {
        return testRepository.findByStatus(status);
    }
}
