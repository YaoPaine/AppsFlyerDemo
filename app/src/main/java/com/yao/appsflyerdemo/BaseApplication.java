package com.yao.appsflyerdemo;

import android.annotation.SuppressLint;
import android.app.Application;
import android.provider.Settings;
import android.util.Log;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;

import java.util.Map;

/**
 * @Description:
 * @Author: YaoPaine
 * @CreateDate: 2018/4/12 上午11:11
 * @Version:
 */
public class BaseApplication extends Application {

    public static final String AF_DEV_KEY = "bRhGdiKC97r7L9uZTD3XMP";

    @Override
    public void onCreate() {
        super.onCreate();
        @SuppressLint("HardwareIds")
        String string = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        AppsFlyerLib.getInstance().setAndroidIdData(string);

        AppsFlyerConversionListener conversionDataListener =
                new AppsFlyerConversionListener() {

                    @Override
                    public void onInstallConversionDataLoaded(Map<String, String> map) {
                        Log.e(AppsFlyerLib.LOG_TAG, "onInstallConversionDataLoaded: " + map);
                    }

                    @Override
                    public void onInstallConversionFailure(String s) {
                        Log.e(AppsFlyerLib.LOG_TAG, "onInstallConversionFailure: " + s);
                    }

                    @Override
                    public void onAppOpenAttribution(Map<String, String> map) {
                        Log.e(AppsFlyerLib.LOG_TAG, "onAppOpenAttribution: " + map);
                    }

                    @Override
                    public void onAttributionFailure(String s) {
                        Log.e(AppsFlyerLib.LOG_TAG, "onAttributionFailure: " + s);
                    }
                };
        AppsFlyerLib.getInstance().init(AF_DEV_KEY, conversionDataListener, getApplicationContext());
        AppsFlyerLib.getInstance().registerConversionListener(this, conversionDataListener);
        AppsFlyerLib.getInstance().startTracking(this, AF_DEV_KEY);
    }
}
