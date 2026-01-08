package com.clarity.testmanagement.test_suite.model.bo;

import com.clarity.testmanagement.common.model.FeatureConfiguration;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TestSuiteFeatureConfiguration extends FeatureConfiguration<TestSuite> {
}
