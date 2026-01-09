package com.clarity.testmanagement.common.service;

import com.clarity.testmanagement.common.model.FeatureConfiguration;
import org.springframework.stereotype.Service;

@Service
public interface BaseService<T extends FeatureConfiguration<?>> {
}
