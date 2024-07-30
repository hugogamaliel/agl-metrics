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
@Table(name = "PROJECT")
public class Project implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROJECT")
    private Long idProject;
    
    @Column(name = "NAME", length = 100)
    private String name;

    public void setIdProject(Long idProject) {
        this.idProject = idProject;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Long getIdProject() {
        return idProject;
    }

    public String getName() {
        return name;
    }
    
}
