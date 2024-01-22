package com.example.weatherwise.Url;

import com.example.weatherwise.Location.LocationCord;

public class URL {

    private String link;

    private static String city_url;

   public  URL() {
       link = "http://api.weatherapi.com/v1/minutely&lat=" + LocationCord.lat + "&lon=" + LocationCord.lon + "&appid" + LocationCord.API_KEY;
   }
    public String getLink() {
        return link;
    }
    public static void setCity_url(String cityName) {
       city_url = "http://api.weatherapi.com/v1/" + cityName +  "&appid=" + LocationCord.API_KEY;
    }
    public static String getCity_url() {
        return city_url;
    }
    }


