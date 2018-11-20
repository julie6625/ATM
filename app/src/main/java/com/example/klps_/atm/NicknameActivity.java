package com.example.klps_.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NicknameActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
    }


    public void next(View view){
        String nickname = ((EditText)findViewById(R.id.ed_nickname)).getText().toString();
        user.setNickname(nickname);//從BaseActivity呼叫user還有set方法即可
        Intent age = new Intent(this,AgeActivity.class);
        startActivity(age);
    }
}
