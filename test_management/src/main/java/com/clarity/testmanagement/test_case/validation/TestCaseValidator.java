package com.clarity.testmanagement.test_case.validation;

import com.clarity.testmanagement.common.model.ValidationError;
import com.clarity.testmanagement.common.validation.BaseValidator;
import com.clarity.testmanagement.test_case.model.bo.TestCase;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestCaseValidator implements BaseValidator<TestCase> {
    
    @Override
    public List<ValidationError> validate(TestCase bo) {
        List<ValidationError> errors = new ArrayList<>();
        
        // Add validation rules here
        // Example:
        // if (bo.getName() == null || bo.getName().isEmpty()) {
        //     errors.add(ValidationError.builder()
        //         .entityId(bo.getId())
        //         .field("name")
        //         .errorCode("REQUIRED")
        //         .message("Name is required")
        //         .severity("ERROR")
        //         .build());
        // }
        
        return errors;
    }
}
