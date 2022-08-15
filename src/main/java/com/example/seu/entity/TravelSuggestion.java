package com.example.seu.entity;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName travel_suggestion
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelSuggestion implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer provinceFromId;

    /**
     * 
     */
    private Integer cityFromId;

    /**
     * 
     */
    private Integer provinceToId;

    /**
     * 
     */
    private Integer cityToId;

    /**
     * 
     */
    private LocalDate time;

    /**
     * 
     */
    private String suggestion;

    private static final long serialVersionUID = 1L;
}