/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agl.metrics.dto;

import com.agl.metrics.entity.IssueType;
import com.agl.metrics.entity.Person;
import com.agl.metrics.entity.Priority;
import com.agl.metrics.entity.Project;
import com.agl.metrics.entity.Status;

/**
 *
 * @author hugo.reyes
 */
public class IssueDTO {
    
    private Long idIssue;
    private IssueType issueType;
    private Project project;
    private Person person;
    private Status status;
    private Priority priority;
    private String jiraCardNumber;
    private Long points;
    private Boolean isBJ;
    private Boolean isPull;
    private Long iteration;
    private String Description;

    public void setIdIssue(Long idIssue) {
        this.idIssue = idIssue;
    }

    public void setIssueType(IssueType issueType) {
        this.issueType = issueType;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setJiraCardNumber(String jiraCardNumber) {
        this.jiraCardNumber = jiraCardNumber;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public void setIsBJ(Boolean isBJ) {
        this.isBJ = isBJ;
    }

    public void setIsPull(Boolean isPull) {
        this.isPull = isPull;
    }

    public void setIteration(Long iteration) {
        this.iteration = iteration;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    
    public String getDescription() {
        return Description;
    }
    
    public Long getIdIssue() {
        return idIssue;
    }

    public Project getProject() {
        return project;
    }

    public Person getPerson() {
        return person;
    }

    public Status getStatus() {
        return status;
    }

    public Priority getPriority() {
        return priority;
    }

    public IssueType getIssueType() {
        return issueType;
    }
    
    public String getJiraCardNumber() {
        return jiraCardNumber;
    }

    public Long getPoints() {
        return points;
    }

    public Boolean getIsBJ() {
        return isBJ;
    }

    public Boolean getIsPull() {
        return isPull;
    }

    public Long getIteration() {
        return iteration;
    }
    
}
