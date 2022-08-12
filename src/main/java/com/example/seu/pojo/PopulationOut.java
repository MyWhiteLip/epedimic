package com.sample;


public class PopulationOut {

  private long id;
  private long provinceId;
  private long cityId;
  private long populationOut;
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


  public long getPopulationOut() {
    return populationOut;
  }

  public void setPopulationOut(long populationOut) {
    this.populationOut = populationOut;
  }


  public java.sql.Date getTime() {
    return time;
  }

  public void setTime(java.sql.Date time) {
    this.time = time;
  }

}
