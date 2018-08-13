package com.c1ctech.androiddagger2example.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class CalenderResponse {
    @SerializedName("data")
    private List<MatchCalender> data;

    public List<MatchCalender> getData() {
        return data;
    }

    public void setData(List<MatchCalender> data) {
        this.data = data;

    }

}
