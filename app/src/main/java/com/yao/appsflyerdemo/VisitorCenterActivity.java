package com.yao.appsflyerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.appsflyer.AppsFlyerLib;

/**
 * @Description:
 * @Author: YaoPaine
 * @CreateDate: 2018/4/12 上午11:34
 * @Version:
 */
public class VisitorCenterActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppsFlyerLib.getInstance().sendDeepLinkData(this);
        Log.e(AppsFlyerLib.LOG_TAG, "onCreate: " + getIntent().getDataString());
        finish();
    }
}
