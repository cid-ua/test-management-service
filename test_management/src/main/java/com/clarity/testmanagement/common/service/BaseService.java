package com.clarity.testmanagement.common.service;

import com.clarity.testmanagement.common.model.BaseBO;
import com.clarity.testmanagement.common.model.FeatureConfiguration;
import com.clarity.testmanagement.common.model.SearchPageRequest;

public interface BaseService<B extends BaseBO, ID> {
    
    FeatureConfiguration<B> getFeatureConfiguration(SearchPageRequest request);
    
    B getItem(ID id);
    
    B saveItem(B bo);
    
    void deleteItem(ID id);
}
