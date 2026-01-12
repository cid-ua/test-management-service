package com.clarity.testmanagement.common.transformation;

import com.clarity.testmanagement.common.model.BaseBO;

/**
 * Base Transformer interface for all features.
 * Responsible for modifying BO according to business rules.
 * 
 * @param <B> Business Object type extending BaseBO
 */
public interface BaseTransformer<B extends BaseBO> {
    
    /**
     * Transform/modify BO before save operation.
     * Apply business rules, defaults, calculated fields, etc.
     */
    B transformForSave(B bo);
    
    /**
     * Transform/modify BO after retrieval.
     * Apply any post-processing rules.
     */
    default B transformAfterRetrieve(B bo) {
        return bo;
    }
}
