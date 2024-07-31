/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agl.metrics.config;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 *
 * @author hugo.reyes
 */
@Primary
@Configuration
public class DataSourceConfig extends DataSourceProperties{
    
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
      public DataSourceProperties dataSourceProperties()
    {
      return new DataSourceProperties();
    }

    @Bean(destroyMethod="close")
    public DataSource getDataSource() {
      DataSourceProperties dataSrcProperties = dataSourceProperties();
      HikariDataSource dataSource = null;

      if(System.getenv("DB_USER_NAME") != null) {
        dataSource = DataSourceBuilder.create(dataSrcProperties.getClassLoader())
          .driverClassName(System.getenv("DB_DRIVER"))
          .url(System.getenv("DB_URL"))
          .username(System.getenv("DB_USER_NAME"))
          .password(System.getenv("DB_PASSWORD"))
          .type(HikariDataSource.class)
          .build();
      } else {
        dataSource = DataSourceBuilder.create(dataSrcProperties.getClassLoader())
          .driverClassName(dataSrcProperties.getDriverClassName())
          .url(dataSrcProperties.getUrl())
          .username(dataSrcProperties.getUsername())
          .password(dataSrcProperties.getPassword())
          .type(HikariDataSource.class)
          .build();
      }

      return dataSource;
    }
}
