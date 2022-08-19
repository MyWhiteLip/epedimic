package com.example.seu.entity;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName epidemic_data
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EpidemicData implements Serializable {
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
    private Integer confirm;

    /**
     * 
     */
    private Integer asymptomatic;

    /**
     * 
     */
    private Integer death;

    /**
     * 
     */
    private Integer cured;

    /**
     * 
     */
    private Integer confirmIncrease;

    /**
     * 
     */
    private Integer asymptomaticIncrease;

    /**
     * 
     */
    private LocalDate time;
    private Integer riskAreaNumber;
    private Integer nowConfirm;

    private static final long serialVersionUID = 1L;
}