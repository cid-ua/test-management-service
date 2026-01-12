package com.clarity.testmanagement.common.controller;

import com.clarity.testmanagement.common.model.BaseDTO;
import com.clarity.testmanagement.common.model.FeatureConfigurationDTO;
import com.clarity.testmanagement.common.model.SearchPageRequest;
import org.springframework.http.ResponseEntity;

/**
 * Base Controller interface for all features.
 * Defines REST endpoints for CRUD operations.
 * 
 * @param <D> Data Transfer Object type extending BaseDTO
 */
public interface BaseController<D extends BaseDTO> {
    
    /**
     * Get feature configuration with paginated data.
     */
    ResponseEntity<FeatureConfigurationDTO<D>> getFeatureConfiguration(SearchPageRequest request);
    
    /**
     * Get single item by ID.
     */
    ResponseEntity<D> getItem(Long id);
    
    /**
     * Save item (create or update).
     */
    ResponseEntity<D> saveItem(D dto);
    
    /**
     * Delete item by ID.
     */
    ResponseEntity<Void> deleteItem(Long id);
}
