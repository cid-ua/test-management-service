package com.clarity.testmanagement.common.transformation;

import com.clarity.testmanagement.common.model.BaseBO;

public interface BaseTransformer<B extends BaseBO> {
    
    B transformForSave(B bo);
    
    default B transformAfterRetrieve(B bo) {
        return bo;
    }
}
