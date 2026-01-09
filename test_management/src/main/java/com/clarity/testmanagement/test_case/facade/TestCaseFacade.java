package com.clarity.testmanagement.test_case.facade;

import com.clarity.testmanagement.common.facade.BaseFacade;
import com.clarity.testmanagement.test_case.model.bo.TestCaseFeatureConfiguration;
import com.clarity.testmanagement.test_case.model.dto.TestCaseFeatureConfigurationDTO;
import org.springframework.stereotype.Component;

@Component
public interface TestCaseFacade extends BaseFacade<TestCaseFeatureConfiguration, TestCaseFeatureConfigurationDTO> {
    
    @Override
    default Class<?> getBOClass() {
        return TestCaseFeatureConfiguration.class;
    }
    
    @Override
    default Class<?> getDTOClass() {
        return TestCaseFeatureConfigurationDTO.class;
    }
}
