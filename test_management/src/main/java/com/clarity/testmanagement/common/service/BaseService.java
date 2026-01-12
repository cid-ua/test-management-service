package com.clarity.testmanagement.common.service;

import com.clarity.testmanagement.common.model.BaseBO;
import com.clarity.testmanagement.common.model.FeatureConfiguration;
import com.clarity.testmanagement.common.model.SearchPageRequest;

/**
 * Base Service interface for all features.
 * Orchestrates Transformer -> Validator -> Repository flow.
 * 
 * @param <B> Business Object type extending BaseBO
 * @param <ID> Primary key type
 */
public interface BaseService<B extends BaseBO, ID> {
    
    /**
     * Get feature configuration with paginated data.
     * Calls transformer, validator, and repository.
     */
    FeatureConfiguration<B> getFeatureConfiguration(SearchPageRequest request);
    
    /**
     * Get single item by ID.
     */
    B getItem(ID id);
    
    /**
     * Save item (create or update).
     * Transforms, validates, then persists.
     */
    B saveItem(B bo);
    
    /**
     * Delete item by ID.
     */
    void deleteItem(ID id);
}
