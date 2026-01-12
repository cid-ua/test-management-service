package com.clarity.testmanagement.common.validation;

import com.clarity.testmanagement.common.model.BaseBO;
import com.clarity.testmanagement.common.model.ValidationError;

import java.util.List;

/**
 * Base Validator interface for all features.
 * Responsible for running validation rules and returning errors.
 * 
 * @param <B> Business Object type extending BaseBO
 */
public interface BaseValidator<B extends BaseBO> {
    
    /**
     * Validate BO and return list of validation errors.
     * Returns empty list if validation passes.
     */
    List<ValidationError> validate(B bo);
    
    /**
     * Validate BO for save operation (create or update).
     */
    default List<ValidationError> validateForSave(B bo) {
        return validate(bo);
    }
    
    /**
     * Validate BO for delete operation.
     */
    default List<ValidationError> validateForDelete(B bo) {
        return List.of();
    }
}
