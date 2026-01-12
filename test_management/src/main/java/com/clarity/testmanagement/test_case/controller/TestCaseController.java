package com.clarity.testmanagement.test_case.controller;

import com.clarity.testmanagement.common.controller.BaseController;
import com.clarity.testmanagement.common.model.FeatureConfigurationDTO;
import com.clarity.testmanagement.common.model.SearchPageRequest;
import com.clarity.testmanagement.test_case.facade.TestCaseFacade;
import com.clarity.testmanagement.test_case.model.dto.TestCaseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test-cases")
@RequiredArgsConstructor
public class TestCaseController implements BaseController<TestCaseDTO> {
    
    private final TestCaseFacade testCaseFacade;
    
    @Override
    @PostMapping("/search")
    public ResponseEntity<FeatureConfigurationDTO<TestCaseDTO>> getFeatureConfiguration(@RequestBody SearchPageRequest request) {
        return ResponseEntity.ok(testCaseFacade.getFeatureConfiguration(request));
    }
    
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDTO> getItem(@PathVariable Long id) {
        return ResponseEntity.ok(testCaseFacade.getItem(id));
    }
    
    @Override
    @PostMapping
    public ResponseEntity<TestCaseDTO> saveItem(@RequestBody TestCaseDTO dto) {
        return ResponseEntity.ok(testCaseFacade.saveItem(dto));
    }
    
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        testCaseFacade.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}
