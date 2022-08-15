package com.example.seu.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName covid_detection_point
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CovidDetectionPoint implements Serializable {
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
    private String detail;

    private static final long serialVersionUID = 1L;

}