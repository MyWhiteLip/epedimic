package com.example.seu.entity;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName epidemic_data_pr
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EpidemicDataPr implements Serializable {
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
    private Integer confirmPr;

    /**
     * 
     */
    private Integer asymptomaticPr;

    /**
     * 
     */
    private Integer deathPr;

    /**
     * 
     */
    private Integer curedPr;

    /**
     * 
     */
    private Integer confirmIncreasePr;

    /**
     * 
     */
    private Integer asymptomaticIncreasePr;

    /**
     * 
     */
    private LocalDate timePr;

    private static final long serialVersionUID = 1L;
}