package com.clarity.testmanagement.common.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeatureConfigurationDTO<T extends ConfigDTO> {
    private T config;
    private boolean enabled;
    private String description;
}
