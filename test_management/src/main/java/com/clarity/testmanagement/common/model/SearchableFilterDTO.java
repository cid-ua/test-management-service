package com.clarity.testmanagement.common.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchableFilterDTO {
    private String text;
    private List<String> features;
    private List<String> userNames;
    private List<String> tags;
    private List<String> applications;
    private List<Integer> excludeIds;
}
