package com.example.seu.entity;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName population_in
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PopulationIn implements Serializable {
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
    private Double populationIn;

    /**
     * 
     */
    private LocalDate time;

    /**
     *
     */
    private int fromProvinceId;

    /**
     *
     */
    private int fromCityId;

    private static final long serialVersionUID = 1L;
}