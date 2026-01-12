package com.clarity.testmanagement.common.facade;

import com.clarity.testmanagement.common.model.BaseBO;
import com.clarity.testmanagement.common.model.BaseDTO;
import com.clarity.testmanagement.common.model.FeatureConfigurationDTO;
import com.clarity.testmanagement.common.model.SearchPageRequest;

/**
 * Base Facade interface for all features.
 * Responsible for DTO <-> BO conversion and orchestrating service calls.
 * 
 * @param <B> Business Object type extending BaseBO
 * @param <D> Data Transfer Object type extending BaseDTO
 */
public interface BaseFacade<B extends BaseBO, D extends BaseDTO> {
    
    /**
     * Get feature configuration with paginated data.
     * Converts service result (BO) to DTO for response.
     */
    FeatureConfigurationDTO<D> getFeatureConfiguration(SearchPageRequest request);
    
    /**
     * Get single item by ID.
     * Converts service result (BO) to DTO for response.
     */
    D getItem(Long id);
    
    /**
     * Save item.
     * Converts input DTO to BO, processes, and returns DTO.
     */
    D saveItem(D dto);
    
    /**
     * Delete item by ID.
     */
    void deleteItem(Long id);
}
