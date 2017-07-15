package com.example.zipper.applicationtest;



import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
   public Button SecondPage,ThirdPage;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                Intent intent = new Intent(getApplicationContext(),ApiActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Page 3",
                        Toast.LENGTH_LONG).show();
            }
        });
    }


}
