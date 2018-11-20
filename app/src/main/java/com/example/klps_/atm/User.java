package com.example.klps_.atm;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;

public class User {

    private  Context context;
    String id;
    String nickname;
    int age;
    int gender; //alt+Insert產生gettter and setter
    String address;
    SharedPreferences setting;
    boolean valid = false;


    public User(Context context){
        this.context = context;
        setting = context.getSharedPreferences("User",Context.MODE_PRIVATE);
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        if(nickname == null){
            nickname = setting.getString("NICKNAME",null);
        }//在此設定nickname擷取方法
        return nickname;
    }

    public void setNickname(String nickname) {
        setting.edit()
                .putString("NICKNAME",nickname).apply();
        this.nickname = nickname;
    }

    public int getAge() {
        if (age == 0){
            age = setting.getInt("AGE",0);
        }
        return age;
    }

    public void setAge(int age) {
        setting.edit()
                .putInt("AGE",age).apply();
        this.age = age;
    }

    public int getGender() {
        if (gender == 0){
            gender = setting.getInt("GENDER",0);
        }
        return gender;
    }

    public void setGender(int gender) {
        setting.edit()
                .putInt("GENDER",gender).apply();
        this.gender = gender;
    }

    public boolean isValid(){
        valid = getNickname() != null && age != 0 && gender != 0;
        return valid;
    }

    public String getAddress() {
        address = "dummy address";
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
