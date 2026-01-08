package com.clarity.testmanagement.common.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeatureConfiguration<T extends Config> {
    private T config;
    private boolean enabled;
    private String description;
}
