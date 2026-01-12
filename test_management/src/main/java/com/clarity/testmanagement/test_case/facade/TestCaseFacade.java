package com.clarity.testmanagement.test_case.facade;

import com.clarity.testmanagement.common.converter.ModelMapperConverter;
import com.clarity.testmanagement.common.facade.BaseFacade;
import com.clarity.testmanagement.common.model.FeatureConfiguration;
import com.clarity.testmanagement.common.model.FeatureConfigurationDTO;
import com.clarity.testmanagement.common.model.PageResult;
import com.clarity.testmanagement.common.model.SearchPageRequest;
import com.clarity.testmanagement.test_case.model.bo.TestCase;
import com.clarity.testmanagement.test_case.model.dto.TestCaseDTO;
import com.clarity.testmanagement.test_case.service.TestCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestCaseFacade implements BaseFacade<TestCase, TestCaseDTO> {
    
    private final TestCaseService testCaseService;

    @Override
    public FeatureConfigurationDTO<TestCaseDTO> getFeatureConfiguration(SearchPageRequest request) {
        // Call service to get BO result
        FeatureConfiguration<TestCase> boResult = testCaseService.getFeatureConfiguration(request);
        
        // Convert BO to DTO
        FeatureConfigurationDTO<TestCaseDTO> dtoResult = new FeatureConfigurationDTO<>();
        dtoResult.setFeatureId(boResult.getFeatureId());
        dtoResult.setFeatureName(boResult.getFeatureName());
        dtoResult.setFeatureDescription(boResult.getFeatureDescription());
        dtoResult.setFeatureTitle(boResult.getFeatureTitle());
        dtoResult.setValidationErrors(boResult.getValidationErrors());
        
        // Convert page result items
        if (boResult.getPageResult() != null) {
            PageResult<TestCaseDTO> dtoPageResult = new PageResult<>();
            List<TestCaseDTO> dtoItems = ModelMapperConverter.toDto(
                    boResult.getPageResult().getItems(), TestCaseDTO.class);
            dtoPageResult.setItems(dtoItems);
            dtoPageResult.setHasNext(boResult.getPageResult().isHasNext());
            dtoPageResult.setHasPrevious(boResult.getPageResult().isHasPrevious());
            dtoPageResult.setSize(boResult.getPageResult().getSize());
            dtoPageResult.setTotalRows(boResult.getPageResult().getTotalRows());
            dtoPageResult.setNextSortColumnValue(boResult.getPageResult().getNextSortColumnValue());
            dtoPageResult.setPreviousSortColumnValue(boResult.getPageResult().getPreviousSortColumnValue());
            dtoResult.setPageResult(dtoPageResult);
        }
        
        return dtoResult;
    }
    
    @Override
    public TestCaseDTO getItem(Long id) {
        TestCase bo = testCaseService.getItem(id);
        return ModelMapperConverter.toDto(bo, TestCaseDTO.class);
    }
    
    @Override
    public TestCaseDTO saveItem(TestCaseDTO dto) {
        // Convert DTO to BO
        TestCase bo = ModelMapperConverter.toBo(dto, TestCase.class);
        
        // Call service
        TestCase savedBo = testCaseService.saveItem(bo);
        
        // Convert result to DTO
        return ModelMapperConverter.toDto(savedBo, TestCaseDTO.class);
    }
    
    @Override
    public void deleteItem(Long id) {
        testCaseService.deleteItem(id);
    }
}
