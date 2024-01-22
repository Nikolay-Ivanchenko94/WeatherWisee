package com.example.weatherwise.Location;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class CityFinder {
    public static void setLongitudeLatitude(Location location) {
        try {
            LocationCord.lat = String.valueOf(location.getLatitude());
            LocationCord.lon = String.valueOf(location.getLongitude());
            Log.d("location_lat", LocationCord.lat);
            Log.d("location_lon", LocationCord.lon);
        } catch (NullPointerException e ) {
            e.printStackTrace();
        }
    }
    public static String getCityNameUsingNetwork(Context context, Location location) {
        String city = "";
        try {
            Geocoder geocoder = new Geocoder(context, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            city = addresses.get(0).getLocality();
            Log.d("Місто", city);
        } catch (Exception e) {
            Log.d("Місто", "Помилка місто не знайденно");
        }
        return city;
    }
}
