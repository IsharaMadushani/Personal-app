package com.industrialmaster.personalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class noteaddActivity extends AppCompatActivity {
    String name = null;
    EditText etNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noteadd);
        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        {
            if (bundle != null) {
                name = bundle.getString("name");

                etNote = findViewById(R.id.note_text);


                try {
                    File file = new File(getFilesDir() + File.separator + "notes" + File.separator + name);
                    FileInputStream fis = new FileInputStream(file);
                    byte[] chars = new byte[fis.available()];
                    fis.read(chars);
                    String text = new String(chars);

                    etNote.setText(text);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(this, "can't read " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }


    }
    public void save(View v){

        //  EditText etNote = findViewById(R.id.note_text);
        String note = etNote.getText().toString();

        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("Y-m-d-H-m");
        String f = sdf.format(today) + ".txt";
        if (name != null) {
            f = name;
        }

        String filename = getFilesDir() + File.separator + "notes" + File.separator + f;
        File file = new File(filename);


        try {
            //   FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);
            FileOutputStream fos = new FileOutputStream(file);

            fos.write(note.getBytes());
            fos.close();
            Toast.makeText(this, "saved!", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error, " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
    public void back(View v){
        Intent intent =  new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
