package com.c1ctech.androiddagger2example.model;

import com.google.gson.annotations.SerializedName;


public class MatchCalender {

    @SerializedName("unique_id")
    private String uniqueId;

    @SerializedName("name")
    private String name;


    @SerializedName("date")
    private String date;

    public MatchCalender(String uniqueId, String name, String date) {
        this.uniqueId = uniqueId;
        this.name = name;
        this.date = date;

    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
