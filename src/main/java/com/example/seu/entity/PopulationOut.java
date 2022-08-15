package com.example.seu.entity;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName population_out
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PopulationOut implements Serializable {
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
    private Integer populationOut;

    /**
     * 
     */
    private LocalDate time;

    /**
     *
     */
    private String toProvinceIn;

    /**
     *
     */
    private String toCityIn;
    private static final long serialVersionUID = 1L;
}