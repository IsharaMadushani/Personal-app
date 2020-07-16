package com.industrialmaster.personalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    protected void onResume(){
        super.onResume();
        SharedPreferences profile = getSharedPreferences("profile", Context.MODE_PRIVATE);

       // TextView tvName =  findViewById(R.id.my_name);
       // TextView tvEmail =  findViewById(R.id.my_email);
      //  TextView tvMobile =  findViewById(R.id.my_mobile);

       // String name =  profile.getString("name", "");
     //   String email =  profile.getString("email", "");
     //   String mobile =  profile.getString("mobile", "");

       // tvName.setText(name);
       // tvEmail.setText(email);
       // tvMobile.setText(mobile);
    }
    public void homework(View v){
        Intent intent =  new Intent(this, homeworkActivity.class);
        startActivity(intent);
    }
    public void todo(View v){
        Intent intent =  new Intent(this, todoActivity.class);
        startActivity(intent);
    }
    public void grocery(View v){
        Intent intent =  new Intent(this, grocerryActivity.class);
        startActivity(intent);
    }
    public void notes(View v){
        Intent intent =  new Intent(this, notesActivity.class);
        startActivity(intent);
    }
    public void travel(View v){
        Intent intent =  new Intent(this, travelActivity.class);
        startActivity(intent);
    }
    public void boooks(View v){
        Intent intent =  new Intent(this, homeworkActivity.class);
        startActivity(intent);
    }
    public void quotes(View v){
        Intent intent =  new Intent(this, homeworkActivity.class);
        startActivity(intent);
    }
    public void profile(View v){
        Intent intent =  new Intent(this, profileActivity.class);
        startActivity(intent);
}
}
