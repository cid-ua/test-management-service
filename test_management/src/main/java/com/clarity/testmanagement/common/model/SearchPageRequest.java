package com.clarity.testmanagement.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchPageRequest {
    private Integer pageIndex;
    private Integer size;
    private CursorDirection direction;
    private SearchableFilterDTO searchFilter;
    private String sortColumn;
    private String sortColumnValue;
    private SortOrder sortColumnOrder;
}
