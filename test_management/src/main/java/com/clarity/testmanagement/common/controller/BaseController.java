package com.clarity.testmanagement.common.controller;

import com.clarity.testmanagement.common.model.BaseDTO;
import com.clarity.testmanagement.common.model.FeatureConfigurationDTO;
import com.clarity.testmanagement.common.model.SearchPageRequest;
import org.springframework.http.ResponseEntity;

public interface BaseController<D extends BaseDTO> {
    
    ResponseEntity<FeatureConfigurationDTO<D>> getFeatureConfiguration(SearchPageRequest request);
    
    ResponseEntity<D> getItem(Long id);
    
    ResponseEntity<D> saveItem(D dto);
    
    ResponseEntity<Void> deleteItem(Long id);
}
