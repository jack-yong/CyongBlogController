package com.cyong;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class CyongBlog {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource dateSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }

    public static void main(String[] args) {
        SpringApplication.run(CyongBlog.class, args);
    }

}
