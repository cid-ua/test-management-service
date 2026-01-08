package com.clarity.testmanagement.test_case.model.dto;

import com.clarity.testmanagement.common.model.FeatureConfigurationDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TestCaseFeatureConfigurationDTO extends FeatureConfigurationDTO<TestCaseDTO> {
}
