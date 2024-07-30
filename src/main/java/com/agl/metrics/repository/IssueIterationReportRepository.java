/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.agl.metrics.repository;

import com.agl.metrics.entity.IssueIterationReport;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author hugo.reyes
 */
public interface IssueIterationReportRepository extends JpaRepository<IssueIterationReport, Long>{
    
    @Query("SELECT i FROM IssueIterationReport i WHERE i.iterationNumber = :iterationNumber")
    List<IssueIterationReport> getIssueIterationReport(@Param("iterationNumber") Long iterationNumber);
    
}
