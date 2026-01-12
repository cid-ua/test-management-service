package com.clarity.testmanagement.test_case.converter;

import com.clarity.testmanagement.common.converter.BaseConverter;
import com.clarity.testmanagement.test_case.model.bo.TestCase;
import com.clarity.testmanagement.test_case.model.dto.TestCaseDTO;
import org.springframework.stereotype.Component;

@Component
public class TestCaseConverter extends BaseConverter<TestCase, TestCaseDTO> {

    public TestCaseConverter() {
        super(TestCase.class, TestCaseDTO.class);
    }
}
