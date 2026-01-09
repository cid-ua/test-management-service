package com.clarity.testmanagement.test_suite.facade;

import com.clarity.testmanagement.common.facade.BaseFacade;
import com.clarity.testmanagement.test_suite.model.bo.TestSuiteFeatureConfiguration;
import com.clarity.testmanagement.test_suite.model.dto.TestSuiteFeatureConfigurationDTO;

public interface TestSuiteFacade extends BaseFacade<TestSuiteFeatureConfiguration, TestSuiteFeatureConfigurationDTO> {
    
    @Override
    default Class<?> getBOClass() {
        return TestSuiteFeatureConfiguration.class;
    }
    
    @Override
    default Class<?> getDTOClass() {
        return TestSuiteFeatureConfigurationDTO.class;
    }
}
