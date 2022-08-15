package com.example.seu.entity;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

/**
 * 
 * @TableName travel_suggestion
 */
@Data
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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TravelSuggestion other = (TravelSuggestion) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProvinceFromId() == null ? other.getProvinceFromId() == null : this.getProvinceFromId().equals(other.getProvinceFromId()))
            && (this.getCityFromId() == null ? other.getCityFromId() == null : this.getCityFromId().equals(other.getCityFromId()))
            && (this.getProvinceToId() == null ? other.getProvinceToId() == null : this.getProvinceToId().equals(other.getProvinceToId()))
            && (this.getCityToId() == null ? other.getCityToId() == null : this.getCityToId().equals(other.getCityToId()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getSuggestion() == null ? other.getSuggestion() == null : this.getSuggestion().equals(other.getSuggestion()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProvinceFromId() == null) ? 0 : getProvinceFromId().hashCode());
        result = prime * result + ((getCityFromId() == null) ? 0 : getCityFromId().hashCode());
        result = prime * result + ((getProvinceToId() == null) ? 0 : getProvinceToId().hashCode());
        result = prime * result + ((getCityToId() == null) ? 0 : getCityToId().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getSuggestion() == null) ? 0 : getSuggestion().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", provinceFromId=").append(provinceFromId);
        sb.append(", cityFromId=").append(cityFromId);
        sb.append(", provinceToId=").append(provinceToId);
        sb.append(", cityToId=").append(cityToId);
        sb.append(", time=").append(time);
        sb.append(", suggestion=").append(suggestion);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}