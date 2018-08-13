package com.c1ctech.androiddagger2example;
import com.c1ctech.androiddagger2example.model.CalenderResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {


    @GET("api/matchCalendar")
    Call<CalenderResponse> getMatchCalender(@Query("apikey") String apiKey);


}
