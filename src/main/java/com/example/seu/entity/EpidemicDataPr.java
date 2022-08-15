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
            && (this.getProvinceId() == null ? other.getProvinceId() == null : this.getProvinceId().equals(other.getProvinceId()))
            && (this.getCityId() == null ? other.getCityId() == null : this.getCityId().equals(other.getCityId()))
            && (this.getConfirmPr() == null ? other.getConfirmPr() == null : this.getConfirmPr().equals(other.getConfirmPr()))
            && (this.getAsymptomaticPr() == null ? other.getAsymptomaticPr() == null : this.getAsymptomaticPr().equals(other.getAsymptomaticPr()))
            && (this.getDeathPr() == null ? other.getDeathPr() == null : this.getDeathPr().equals(other.getDeathPr()))
            && (this.getCuredPr() == null ? other.getCuredPr() == null : this.getCuredPr().equals(other.getCuredPr()))
            && (this.getConfirmIncreasePr() == null ? other.getConfirmIncreasePr() == null : this.getConfirmIncreasePr().equals(other.getConfirmIncreasePr()))
            && (this.getAsymptomaticIncreasePr() == null ? other.getAsymptomaticIncreasePr() == null : this.getAsymptomaticIncreasePr().equals(other.getAsymptomaticIncreasePr()))
            && (this.getTimePr() == null ? other.getTimePr() == null : this.getTimePr().equals(other.getTimePr()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProvinceId() == null) ? 0 : getProvinceId().hashCode());
        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());
        result = prime * result + ((getConfirmPr() == null) ? 0 : getConfirmPr().hashCode());
        result = prime * result + ((getAsymptomaticPr() == null) ? 0 : getAsymptomaticPr().hashCode());
        result = prime * result + ((getDeathPr() == null) ? 0 : getDeathPr().hashCode());
        result = prime * result + ((getCuredPr() == null) ? 0 : getCuredPr().hashCode());
        result = prime * result + ((getConfirmIncreasePr() == null) ? 0 : getConfirmIncreasePr().hashCode());
        result = prime * result + ((getAsymptomaticIncreasePr() == null) ? 0 : getAsymptomaticIncreasePr().hashCode());
        result = prime * result + ((getTimePr() == null) ? 0 : getTimePr().hashCode());
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
        sb.append(", confirmPr=").append(confirmPr);
        sb.append(", asymptomaticPr=").append(asymptomaticPr);
        sb.append(", deathPr=").append(deathPr);
        sb.append(", curedPr=").append(curedPr);
        sb.append(", confirmIncreasePr=").append(confirmIncreasePr);
        sb.append(", asymptomaticIncreasePr=").append(asymptomaticIncreasePr);
        sb.append(", timePr=").append(timePr);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}