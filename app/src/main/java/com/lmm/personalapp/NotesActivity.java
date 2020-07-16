package com.lmm.personalapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class NotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotesActivity.this,NoteAddActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        try{
            File folder = new File(getFilesDir()+File.separator+"notes");
            folder.mkdir();

            //Load notes
            String[] files = folder.list();
            ListView listView = findViewById(R.id.note_list);
            int layout = android.R.layout.simple_list_item_1;

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,layout,files);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    TextView tv = (TextView) view;
                    String name = tv.getText().toString();

                    //Send text name to the next screen
                    Intent intent = new Intent(NotesActivity.this,NoteAddActivity.class);
                    intent.putExtra("name",name);
                    startActivity(intent);
//                    Toast.makeText(NotesActivity.this,"Clicked = "+name,Toast.LENGTH_SHORT).show();

                }
            });

        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this,"Folder not created,"+e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}
