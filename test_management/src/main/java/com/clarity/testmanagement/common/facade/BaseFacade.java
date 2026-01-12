package com.clarity.testmanagement.common.facade;

import com.clarity.testmanagement.common.model.BaseBO;
import com.clarity.testmanagement.common.model.BaseDTO;
import com.clarity.testmanagement.common.model.FeatureConfigurationDTO;
import com.clarity.testmanagement.common.model.SearchPageRequest;

public interface BaseFacade<B extends BaseBO, D extends BaseDTO> {
    
    FeatureConfigurationDTO<D> getFeatureConfiguration(SearchPageRequest request);
    
    D getItem(Long id);
    
    D saveItem(D dto);
    
    void deleteItem(Long id);
}
