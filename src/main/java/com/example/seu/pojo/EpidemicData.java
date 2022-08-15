package com.example.seu.pojo;


public class EpidemicData {

  private long id;
  private long provinceId;
  private long cityId;
  private long confirm;
  private long asymptomatic;
  private long death;
  private long cured;
  private long confirmIncrease;
  private long asymptomaticIncrease;
  private java.sql.Date time;


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


  public long getConfirm() {
    return confirm;
  }

  public void setConfirm(long confirm) {
    this.confirm = confirm;
  }


  public long getAsymptomatic() {
    return asymptomatic;
  }

  public void setAsymptomatic(long asymptomatic) {
    this.asymptomatic = asymptomatic;
  }


  public long getDeath() {
    return death;
  }

  public void setDeath(long death) {
    this.death = death;
  }


  public long getCured() {
    return cured;
  }

  public void setCured(long cured) {
    this.cured = cured;
  }


  public long getConfirmIncrease() {
    return confirmIncrease;
  }

  public void setConfirmIncrease(long confirmIncrease) {
    this.confirmIncrease = confirmIncrease;
  }


  public long getAsymptomaticIncrease() {
    return asymptomaticIncrease;
  }

  public void setAsymptomaticIncrease(long asymptomaticIncrease) {
    this.asymptomaticIncrease = asymptomaticIncrease;
  }


  public java.sql.Date getTime() {
    return time;
  }

  public void setTime(java.sql.Date time) {
    this.time = time;
  }

}
