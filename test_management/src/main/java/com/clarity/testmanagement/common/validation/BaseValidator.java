package com.clarity.testmanagement.common.validation;

import com.clarity.testmanagement.common.model.BaseBO;
import com.clarity.testmanagement.common.model.ValidationError;

import java.util.List;

public interface BaseValidator<B extends BaseBO> {
    
    List<ValidationError> validate(B bo);
    
    default List<ValidationError> validateForSave(B bo) {
        return validate(bo);
    }
    
    default List<ValidationError> validateForDelete(B bo) {
        return List.of();
    }
}
