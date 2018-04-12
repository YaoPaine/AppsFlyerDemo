package com.yao.appsflyerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.appsflyer.AppsFlyerLib;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化sdk
        String senderId = "909500648410"; // A.K.A Project Number;
        AppsFlyerLib.getInstance().enableUninstallTracking(senderId); // ADD THIS LINE HERE
        AppsFlyerLib.getInstance().startTracking(getApplication(), BaseApplication.AF_DEV_KEY);
    }
}
