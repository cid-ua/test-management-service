package com.clarity.testmanagement.common.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeatureConfiguration<B extends BaseBO> {
    private PageResult<B> pageResult;
    private int featureId;
    private String featureName;
    private String featureDescription;
    private String featureTitle;
    private List<ValidationError> validationErrors;
}
