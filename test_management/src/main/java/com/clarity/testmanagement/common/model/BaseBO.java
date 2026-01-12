package com.clarity.testmanagement.common.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseBO {
    private Long id;
    private String createdBy;
    private String modifiedBy;
}
