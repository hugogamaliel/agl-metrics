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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author hugo.reyes
 */
@Entity
@Table(name = "ISSUE")
public class Issue implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ISSUE")
    private Long idIssue;

    @JoinColumn(name = "ID_ISSUE_TYPE")
    @OneToOne
    private IssueType issueType;
    
    @JoinColumn(name = "ID_PERSON")
    @OneToOne
    private Person person;
    
    @JoinColumn(name = "ID_PROJECT")
    @OneToOne
    private Project project;
    
    @JoinColumn(name = "ID_STATUS")
    @OneToOne
    private Status status;
    
    @JoinColumn(name = "ID_PRIORITY")
    @OneToOne
    private Priority priority;
    
    @Column(name = "JIRA_CARD", length = 100)
    private String jiraCard;

    @Column(name = "POINTS")
    private Long points;
    
    @Column(name = "IS_BJ")
    private boolean isBJ;
    
    @Column(name = "IS_PULL")
    private boolean isPull;
    
    @Column(name = "ITERATION")
    private Long iteration;
    
    @Column(name = "DESCRIPTION", length = 500)
    private String description;
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getIdIssue() {
        return idIssue;
    }

    public IssueType getIssueType() {
        return issueType;
    }

    public Person getPerson() {
        return person;
    }

    public Project getProject() {
        return project;
    }

    public Status getStatus() {
        return status;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getJiraCard() {
        return jiraCard;
    }

    public Long getPoints() {
        return points;
    }
    
    public boolean getIsBJ() {
        return isBJ;
    }

    public boolean getIsPull() {
        return isPull;
    }

    public Long getIteration() {
        return iteration;
    }

    public String getDescription() {
        return description;
    }
    
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

    public void setJiraCard(String jiraCard) {
        this.jiraCard = jiraCard;
    }

    public void setPoints(Long points) {
        this.points = points;
    }
    
    public void setIsBJ(boolean isBJ) {
        this.isBJ = isBJ;
    }

    public void setIsPull(boolean isPull) {
        this.isPull = isPull;
    }

    public void setIteration(Long iteration) {
        this.iteration = iteration;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
