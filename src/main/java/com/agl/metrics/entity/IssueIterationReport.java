/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agl.metrics.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author hugo.reyes
 */
@Entity
@Table(name = "ISSUE_ITERATION_REPORT")
public class IssueIterationReport implements Serializable {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ISSUE")
    private Long idIssue;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "POINTS")
    private Long points;
    
    @Column(name = "ITERATION")
    private Long iterationNumber;
    
    public Long getIdIssue() {
        return idIssue;
    }
    
    public String getName() {
        return name;
    }

    public Long getPoints() {
        return points;
    }

    public Long getIterationNumber() {
        return iterationNumber;
    }
    
    public void setIdIssue(Long idIssue) {
        this.idIssue = idIssue;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public void setIterationNumber(Long iterationNumber) {
        this.iterationNumber = iterationNumber;
    }
    
}
