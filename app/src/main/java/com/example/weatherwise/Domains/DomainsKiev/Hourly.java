package com.example.weatherwise.Domains.DomainsKiev;

public class Hourly {

    private int temp;
    private String hour;
    private String picPath;

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public Hourly(int temp, String hour, String picPath) {
        this.temp = temp;
        this.hour = hour;
        this.picPath = picPath;
    }
}
