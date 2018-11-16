package com.example.klps_.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    boolean logon  = false;
    public static final int RC_LOGIN=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if ( !logon){ //如未登入則開啟loginActivity
            Intent intent = new Intent(this,LoginActivity.class);
            startActivityForResult(intent, RC_LOGIN);

        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_LOGIN){
            if(resultCode != RESULT_OK){
                    finish();
            }else{
                    Intent nickname = new Intent(this,NicknameActivity.class);
                    startActivity(nickname);
            }
        }
    }
}
