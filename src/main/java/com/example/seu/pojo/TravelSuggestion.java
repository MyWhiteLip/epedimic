package com.sample;


public class TravelSuggestion {

  private long id;
  private long provinceFromId;
  private long cityFromId;
  private long provinceToId;
  private long cityToId;
  private java.sql.Date time;
  private String suggestion;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getProvinceFromId() {
    return provinceFromId;
  }

  public void setProvinceFromId(long provinceFromId) {
    this.provinceFromId = provinceFromId;
  }


  public long getCityFromId() {
    return cityFromId;
  }

  public void setCityFromId(long cityFromId) {
    this.cityFromId = cityFromId;
  }


  public long getProvinceToId() {
    return provinceToId;
  }

  public void setProvinceToId(long provinceToId) {
    this.provinceToId = provinceToId;
  }


  public long getCityToId() {
    return cityToId;
  }

  public void setCityToId(long cityToId) {
    this.cityToId = cityToId;
  }


  public java.sql.Date getTime() {
    return time;
  }

  public void setTime(java.sql.Date time) {
    this.time = time;
  }


  public String getSuggestion() {
    return suggestion;
  }

  public void setSuggestion(String suggestion) {
    this.suggestion = suggestion;
  }

}
