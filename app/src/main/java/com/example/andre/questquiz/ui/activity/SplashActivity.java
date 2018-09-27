package com.example.andre.questquiz.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.example.andre.questquiz.MainActivity;
import com.example.andre.questquiz.R;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
    }
    public void init(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                    startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                    finish();
            }
        },5000);

    }
}
