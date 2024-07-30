/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.agl.metrics.repository;

import com.agl.metrics.dto.IssueIterationReportDTO;
import com.agl.metrics.entity.Issue;
import com.agl.metrics.entity.IssueIterationReport;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author hugo.reyes
 */
public interface IssueRepository extends JpaRepository<Issue, Long> {
    
    @Query("SELECT c FROM Issue c WHERE c.jiraCard = :jiraCardNumber")
    Optional<Issue> findByJiraCardNumber(@Param("jiraCardNumber") String jiraCardNumber);
            
    @Query(value = "SELECT * FROM ISSUE_ITERATION_REPORT WHERE ITERATION = :iterationNumber", nativeQuery=true)
    List<Object[]> getIssueIterationReport(@Param("iterationNumber") Long iterationNumber);
    
}
