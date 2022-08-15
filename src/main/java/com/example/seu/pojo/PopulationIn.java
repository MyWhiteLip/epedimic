package com.example.seu.pojo;


public class PopulationIn {

  private long id;
  private long provinceId;
  private long cityId;
  private long populationIn;
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


  public long getPopulationIn() {
    return populationIn;
  }

  public void setPopulationIn(long populationIn) {
    this.populationIn = populationIn;
  }


  public java.sql.Date getTime() {
    return time;
  }

  public void setTime(java.sql.Date time) {
    this.time = time;
  }

}
