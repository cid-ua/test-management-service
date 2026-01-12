package com.clarity.testmanagement.test_case.facade;

import com.clarity.testmanagement.common.facade.BaseFacade;
import com.clarity.testmanagement.common.model.FeatureConfigurationDTO;
import com.clarity.testmanagement.common.model.SearchPageRequest;
import com.clarity.testmanagement.test_case.converter.TestCaseConverter;
import com.clarity.testmanagement.test_case.model.bo.TestCase;
import com.clarity.testmanagement.test_case.model.dto.TestCaseDTO;
import com.clarity.testmanagement.test_case.service.TestCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestCaseFacade implements BaseFacade<TestCase, TestCaseDTO> {
    
    private final TestCaseService testCaseService;
    private final TestCaseConverter converter;

    @Override
    public FeatureConfigurationDTO<TestCaseDTO> getFeatureConfiguration(SearchPageRequest request) {
        return converter.toFeatureDto(testCaseService.getFeatureConfiguration(request));
    }
    
    @Override
    public TestCaseDTO getItem(Long id) {
        return converter.toDto(testCaseService.getItem(id));
    }
    
    @Override
    public TestCaseDTO saveItem(TestCaseDTO dto) {
        TestCase savedBo = testCaseService.saveItem(converter.toBo(dto));
        return converter.toDto(savedBo);
    }
    
    @Override
    public void deleteItem(Long id) {
        testCaseService.deleteItem(id);
    }
}
