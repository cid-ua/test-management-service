package com.clarity.testmanagement.common.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeatureConfigurationDTO<D extends BaseDTO> {
    private PageResult<D> pageResult;
    private int featureId;
    private String featureName;
    private String featureDescription;
    private String featureTitle;
    private List<ValidationError> validationErrors;
}
