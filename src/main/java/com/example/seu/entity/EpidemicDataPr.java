package com.example.seu.entity;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

/**
 * 
 * @TableName epidemic_data_pr
 */
@Data
public class EpidemicDataPr implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String country;

    /**
     * 
     */
    private LocalDate time;

    /**
     * 
     */
    private Integer confirmIncrease;

    /**
     * 
     */
    private Integer isPredicted;

    /**
     * 
     */
    private String mark;

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
        EpidemicDataPr other = (EpidemicDataPr) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getConfirmIncrease() == null ? other.getConfirmIncrease() == null : this.getConfirmIncrease().equals(other.getConfirmIncrease()))
            && (this.getIsPredicted() == null ? other.getIsPredicted() == null : this.getIsPredicted().equals(other.getIsPredicted()))
            && (this.getMark() == null ? other.getMark() == null : this.getMark().equals(other.getMark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getConfirmIncrease() == null) ? 0 : getConfirmIncrease().hashCode());
        result = prime * result + ((getIsPredicted() == null) ? 0 : getIsPredicted().hashCode());
        result = prime * result + ((getMark() == null) ? 0 : getMark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", country=").append(country);
        sb.append(", time=").append(time);
        sb.append(", confirmIncrease=").append(confirmIncrease);
        sb.append(", isPredicted=").append(isPredicted);
        sb.append(", mark=").append(mark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}