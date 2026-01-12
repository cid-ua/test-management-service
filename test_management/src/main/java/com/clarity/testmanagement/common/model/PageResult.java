package com.clarity.testmanagement.common.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> {
    private List<T> items;
    private boolean hasNext;
    private boolean hasPrevious;
    private int size;
    private int totalRows;
    private String nextSortColumnValue;
    private String previousSortColumnValue;
}
