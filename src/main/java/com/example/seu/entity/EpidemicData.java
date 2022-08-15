package com.example.seu.entity;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

/**
 * 
 * @TableName epidemic_data
 */
@Data
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
        EpidemicData other = (EpidemicData) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProvinceId() == null ? other.getProvinceId() == null : this.getProvinceId().equals(other.getProvinceId()))
            && (this.getCityId() == null ? other.getCityId() == null : this.getCityId().equals(other.getCityId()))
            && (this.getConfirm() == null ? other.getConfirm() == null : this.getConfirm().equals(other.getConfirm()))
            && (this.getAsymptomatic() == null ? other.getAsymptomatic() == null : this.getAsymptomatic().equals(other.getAsymptomatic()))
            && (this.getDeath() == null ? other.getDeath() == null : this.getDeath().equals(other.getDeath()))
            && (this.getCured() == null ? other.getCured() == null : this.getCured().equals(other.getCured()))
            && (this.getConfirmIncrease() == null ? other.getConfirmIncrease() == null : this.getConfirmIncrease().equals(other.getConfirmIncrease()))
            && (this.getAsymptomaticIncrease() == null ? other.getAsymptomaticIncrease() == null : this.getAsymptomaticIncrease().equals(other.getAsymptomaticIncrease()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProvinceId() == null) ? 0 : getProvinceId().hashCode());
        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());
        result = prime * result + ((getConfirm() == null) ? 0 : getConfirm().hashCode());
        result = prime * result + ((getAsymptomatic() == null) ? 0 : getAsymptomatic().hashCode());
        result = prime * result + ((getDeath() == null) ? 0 : getDeath().hashCode());
        result = prime * result + ((getCured() == null) ? 0 : getCured().hashCode());
        result = prime * result + ((getConfirmIncrease() == null) ? 0 : getConfirmIncrease().hashCode());
        result = prime * result + ((getAsymptomaticIncrease() == null) ? 0 : getAsymptomaticIncrease().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", provinceId=").append(provinceId);
        sb.append(", cityId=").append(cityId);
        sb.append(", confirm=").append(confirm);
        sb.append(", asymptomatic=").append(asymptomatic);
        sb.append(", death=").append(death);
        sb.append(", cured=").append(cured);
        sb.append(", confirmIncrease=").append(confirmIncrease);
        sb.append(", asymptomaticIncrease=").append(asymptomaticIncrease);
        sb.append(", time=").append(time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}