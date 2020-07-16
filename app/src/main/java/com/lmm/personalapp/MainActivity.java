package com.lmm.personalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences profile = getSharedPreferences("profile", Context.MODE_PRIVATE);

        TextView tvName = findViewById(R.id.my_name);
        TextView tvEmail = findViewById(R.id.my_email);
        TextView tvMobile = findViewById(R.id.my_mobile);

        String name = profile.getString("name","");
        String emil = profile.getString("email","");
        String mobile = profile.getString("mobile","");

        tvName.setText(name);
        tvEmail.setText(emil);
        tvMobile.setText(mobile);

    }

    public void notes(View v){
        Intent intent = new Intent(this,NotesActivity.class);
        startActivity(intent);
    }

    public void tasks(View v){
        Intent intent = new Intent(this,TasksActivity.class);
        startActivity(intent);

    }

    public void targets(View v){
        Intent intent = new Intent(this,TargetsActivity.class);
        startActivity(intent);
    }

    public void profile(View v){
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }
}
