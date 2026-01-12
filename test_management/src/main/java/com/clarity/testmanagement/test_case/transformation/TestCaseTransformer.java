package com.clarity.testmanagement.test_case.transformation;

import com.clarity.testmanagement.common.transformation.BaseTransformer;
import com.clarity.testmanagement.test_case.model.bo.TestCase;
import org.springframework.stereotype.Component;

@Component
public class TestCaseTransformer implements BaseTransformer<TestCase> {
    
    @Override
    public TestCase transformForSave(TestCase bo) {
        // Apply business rules before save
        // Example: set defaults, calculate fields, etc.
        return bo;
    }
    
    @Override
    public TestCase transformAfterRetrieve(TestCase bo) {
        // Apply post-processing rules after retrieval
        return bo;
    }
}
