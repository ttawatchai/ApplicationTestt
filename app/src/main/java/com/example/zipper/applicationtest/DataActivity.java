package com.example.zipper.applicationtest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DataActivity extends AppCompatActivity {
    public static final String PREFS_NAME = "MyPrefsFile";
    Button add;
    EditText tvShow;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        add = (Button) findViewById(R.id.addButton);
        tvShow = (EditText) findViewById(R.id.tvShow);
        check();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = tvShow.getText().toString();
                if(name != null) {
                            SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
                            editor.putString("name",name);
                            editor.apply();
                }
                else {

                }
            }

        });
        add.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

                return false;
            }
        });



    }
    public void check()
    {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String restoredText = prefs.getString("name", null);
        if (restoredText != null) {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            String name = prefs.getString("name", "No name defined");//"No name defined" is the default value.
            tvShow.setText(name);
        }
        else
        {
            tvShow.setText(null);
        }
    }
}
