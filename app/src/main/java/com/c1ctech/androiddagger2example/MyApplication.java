package com.c1ctech.androiddagger2example;

import android.app.Application;

import com.c1ctech.androiddagger2example.module.ApiClientModule;
import com.c1ctech.androiddagger2example.module.AppModule;

public class MyApplication extends Application {

    private ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApiComponent = DaggerApiComponent.builder()
                .appModule(new AppModule(this))
                .apiClientModule(new ApiClientModule("http://cricapi.com/"))
                .build();
    }

    public ApiComponent getComponent() {
        return mApiComponent;
    }
}
