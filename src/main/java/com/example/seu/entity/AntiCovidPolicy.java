package com.example.seu.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName anti_covid_policy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AntiCovidPolicy implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer provinceId;

    /**
     * 
     */
    private Integer cityId;

    /**
     * 
     */
    private String policy;

    private static final long serialVersionUID = 1L;
}