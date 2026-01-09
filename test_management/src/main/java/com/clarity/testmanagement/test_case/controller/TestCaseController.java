package com.clarity.testmanagement.test_case.controller;

import org.springframework.web.bind.annotation.RestController;

import com.clarity.testmanagement.common.controller.BaseController;
import com.clarity.testmanagement.test_case.model.bo.TestCaseFeatureConfiguration;
import com.clarity.testmanagement.test_case.model.dto.TestCaseFeatureConfigurationDTO;

@RestController
public class TestCaseController implements BaseController<TestCaseFeatureConfiguration, TestCaseFeatureConfigurationDTO> {
}
