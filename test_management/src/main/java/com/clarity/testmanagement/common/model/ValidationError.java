package com.clarity.testmanagement.common.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValidationError {
    private Long entityId;
    private String field;
    private String errorCode;
    private String message;
    private String severity;
}
