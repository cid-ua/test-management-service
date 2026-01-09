package com.clarity.testmanagement.common.controller;

import com.clarity.testmanagement.common.model.FeatureConfiguration;
import com.clarity.testmanagement.common.model.FeatureConfigurationDTO;

public interface BaseController<F extends FeatureConfiguration<?>, T extends FeatureConfigurationDTO<?>> {
}
