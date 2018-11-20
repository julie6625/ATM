package com.example.klps_.atm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity { // 先extend AppCompatActivity獲得activity的功能，稍後方便繼承給其他class
    User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = new User(this); //之後只要呼叫user進行gett動作就好了
    }
}
