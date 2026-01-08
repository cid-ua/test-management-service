package com.clarity.testmanagement.repository;

import com.clarity.testmanagement.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
    
    List<Test> findByStatus(Test.TestStatus status);
    
    List<Test> findByCreatedBy(String createdBy);
    
    @Query("SELECT t FROM Test t WHERE t.name LIKE %:name%")
    List<Test> findByNameContaining(String name);
}
