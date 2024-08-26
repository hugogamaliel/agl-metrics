/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agl.metrics.dto;

/**
 *
 * @author hugo.reyes
 */
public class IssueIterationReportDTO {
    
    private String name;
    private Long points;
    private Long iterationNumber;
    
    public String getName() {
        return name;
    }

    public Long getPoints() {
        return points;
    }

    public Long getIterationNumber() {
        return iterationNumber;
    }
    
    public IssueIterationReportDTO(String name, Long points, Long iterationNumber)
    {
        this.name = name;
        this.points = points;
        this.iterationNumber = iterationNumber;
    }
    
    /*
    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public void setIterationNumber(Long iterationNumber) {
        this.iterationNumber = iterationNumber;
    }
    */
}
