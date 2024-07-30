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
@Table(name = "ISSUE_TYPE")
public class IssueType implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ISSUE_TYPE")
    private Long idIssueType;
    
    @Column(name = "NAME", length = 100)
    private String name;

    public void setIdIssueType(Long idIssueType) {
        this.idIssueType = idIssueType;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Long getIdIssueType() {
        return idIssueType;
    }

    public String getName() {
        return name;
    }
}
