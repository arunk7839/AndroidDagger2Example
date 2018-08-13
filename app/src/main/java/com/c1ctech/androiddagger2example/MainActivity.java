package com.c1ctech.androiddagger2example;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.c1ctech.androiddagger2example.adapter.MatchCalenderAdapter;
import com.c1ctech.androiddagger2example.model.CalenderResponse;
import com.c1ctech.androiddagger2example.model.MatchCalender;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Inject
    Retrofit retrofit;

    @Inject
    Application application;

    private final static String API_KEY = "ENTER YOUR API KEY";
    private static final String TAG = MainActivity.class.getSimpleName();
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MyApplication) getApplication()).getComponent().inject(this);


        recyclerView = (RecyclerView) findViewById(R.id.match_calender_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        ApiInterface apiService = retrofit.create(ApiInterface.class);

        Call<CalenderResponse> call = apiService.getMatchCalender(API_KEY);
        call.enqueue(new Callback<CalenderResponse>() {
            @Override
            public void onResponse(Call<CalenderResponse> call, Response<CalenderResponse> response) {
                int statuscode = response.code();
                List<MatchCalender> matchlist = response.body().getData();
                recyclerView.setAdapter(new MatchCalenderAdapter(matchlist, application));

            }

            @Override
            public void onFailure(Call<CalenderResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }
}
