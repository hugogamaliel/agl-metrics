/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.agl.metrics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 * @author hugo.reyes
 */
@SpringBootApplication
@EnableScheduling
public class AglMetrics {

    public static void main(String[] args) {
        SpringApplication.run(AglMetrics.class, args);
    }
}
