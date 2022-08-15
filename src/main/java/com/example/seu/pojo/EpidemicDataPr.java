package com.example.seu.pojo;


public class EpidemicDataPr {

  private long id;
  private long provinceId;
  private long cityId;
  private long confirmPr;
  private long asymptomaticPr;
  private long deathPr;
  private long curedPr;
  private long confirmIncreasePr;
  private long asymptomaticIncreasePr;
  private java.sql.Date timePr;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getProvinceId() {
    return provinceId;
  }

  public void setProvinceId(long provinceId) {
    this.provinceId = provinceId;
  }


  public long getCityId() {
    return cityId;
  }

  public void setCityId(long cityId) {
    this.cityId = cityId;
  }


  public long getConfirmPr() {
    return confirmPr;
  }

  public void setConfirmPr(long confirmPr) {
    this.confirmPr = confirmPr;
  }


  public long getAsymptomaticPr() {
    return asymptomaticPr;
  }

  public void setAsymptomaticPr(long asymptomaticPr) {
    this.asymptomaticPr = asymptomaticPr;
  }


  public long getDeathPr() {
    return deathPr;
  }

  public void setDeathPr(long deathPr) {
    this.deathPr = deathPr;
  }


  public long getCuredPr() {
    return curedPr;
  }

  public void setCuredPr(long curedPr) {
    this.curedPr = curedPr;
  }


  public long getConfirmIncreasePr() {
    return confirmIncreasePr;
  }

  public void setConfirmIncreasePr(long confirmIncreasePr) {
    this.confirmIncreasePr = confirmIncreasePr;
  }


  public long getAsymptomaticIncreasePr() {
    return asymptomaticIncreasePr;
  }

  public void setAsymptomaticIncreasePr(long asymptomaticIncreasePr) {
    this.asymptomaticIncreasePr = asymptomaticIncreasePr;
  }


  public java.sql.Date getTimePr() {
    return timePr;
  }

  public void setTimePr(java.sql.Date timePr) {
    this.timePr = timePr;
  }

}
