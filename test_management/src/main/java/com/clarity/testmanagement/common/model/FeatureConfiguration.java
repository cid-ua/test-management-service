package com.clarity.testmanagement.common.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeatureConfiguration<T extends ConfigBO> {
    private T config;
    private boolean enabled;
    private String description;
}
