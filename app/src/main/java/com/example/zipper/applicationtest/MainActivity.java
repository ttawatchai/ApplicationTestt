package com.example.zipper.applicationtest;



import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



import static com.example.zipper.applicationtest.DataActivity.PREFS_NAME;
import static com.example.zipper.applicationtest.R.id.username;


public class MainActivity extends AppCompatActivity {
   public Button SecondPage,ThirdPage;
    String json_strng;
    TextView TV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TV = (TextView) findViewById(username);
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String restoredText = prefs.getString("name", null);
        if (restoredText != null) {
            String name = prefs.getString("name", "No name defined");//"No name defined" is the default value.
//            Log.d("check",name);
            TV.setText(name);

        }

        SecondPage =(Button) findViewById(R.id.second);
        ThirdPage = (Button) findViewById(R.id.third);
        SecondPage.setOnClickListener(new View.OnClickListener()
        {



            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),InputActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Page 2",
                        Toast.LENGTH_LONG).show();



            }
        });
        ThirdPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                ApiFragment apiFragment = new ApiFragment();
//                transaction.replace(R.id.frame,apiFragment,"data");
//                transaction.addToBackStack(null);
//                transaction.commit();


                Intent intent = new Intent(getApplicationContext(),ApiViewActivity.class);
                intent.putExtra("json_data",json_strng);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Page 3",
                        Toast.LENGTH_LONG).show();
            }
        });
    }







}
