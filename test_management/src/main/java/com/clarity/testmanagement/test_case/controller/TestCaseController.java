package com.clarity.testmanagement.test_case.controller;

import com.clarity.testmanagement.common.controller.BaseController;
import com.clarity.testmanagement.test_case.model.bo.TestCaseFeatureConfiguration;
import com.clarity.testmanagement.test_case.model.dto.TestCaseFeatureConfigurationDTO;
import org.springframework.stereotype.Component;

@Component
public interface TestCaseController extends BaseController<TestCaseFeatureConfiguration, TestCaseFeatureConfigurationDTO> {
}
