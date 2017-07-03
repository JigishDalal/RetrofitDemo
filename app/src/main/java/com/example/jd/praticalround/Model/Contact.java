package com.example.jd.praticalround.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by JD on 01-07-2017.
 */

public class Contact {
    @SerializedName("firstName")
    private  String firstName;
    @SerializedName("lastName")
    private  String LastName;

    @SerializedName("designation")
    private  String designation;
    @SerializedName("lattitude")
    private String lattiitude;
    @SerializedName("longitude")
    private String longitude;
    @SerializedName("image")
    private String image;

    public Contact(String firstName, String lastName, String designation, String lattiitude, String longitude, String image) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setDesignation(designation);
        this.setLattiitude(lattiitude);
        this.setLongitude(longitude);
        this.setImage(image);

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getDesignation() {
        return designation;
    }

    public String getLattiitude() {
        return lattiitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getImage() {
        return image;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setLattiitude(String lattiitude) {
        this.lattiitude = lattiitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
