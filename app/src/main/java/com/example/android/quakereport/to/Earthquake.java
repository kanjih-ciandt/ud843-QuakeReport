package com.example.android.quakereport.to;

import java.util.Date;

/**
 * Created by kneto on 2/6/17.
 */

public class Earthquake {

    private double magnitude;
    private String place;
    private Date date;

    public Earthquake(double magnitude, String place, Date date) {
        this.magnitude = magnitude;
        this.place = place;
        this.date = date;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
