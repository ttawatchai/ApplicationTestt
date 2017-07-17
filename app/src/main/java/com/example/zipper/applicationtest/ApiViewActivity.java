package com.example.zipper.applicationtest;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import Model.ApiAdapter;
import Model.DataApi;

public class ApiViewActivity extends AppCompatActivity {

    ArrayList<DataApi> arrayList;
//    JSONArray jsonArray;
//    JSONObject  jsonObject;
//    String json_string;
//    ApiAdapter apiAdapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        arrayList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.apiList);

        runOnUiThread(new Runnable() {
@Override
public void run() {
        new ReadJSON().execute("http://www.mocky.io/v2/59659c44110000c600c8f20e");
        }
        });
        }

class ReadJSON extends AsyncTask<String, Integer, String> {

    @Override
    protected String doInBackground(String... params) {
        return readURL(params[0]);
    }

    @Override
    protected void onPostExecute(String content) {
        try {
            JSONObject jsonObject = new JSONObject(content);
            JSONArray jsonArray =  jsonObject.getJSONArray("data");

            for(int i =0;i<jsonArray.length(); i++){
                JSONObject DataObj = jsonArray.getJSONObject(i);
                arrayList.add(new DataApi(
                        DataObj.getString("title"),
                        DataObj.getString("description"),
                        DataObj.getString("urlToImage")
                ));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ApiAdapter adapter = new ApiAdapter(
                getApplicationContext(), R.layout.list_api, arrayList
        );
        listView.setAdapter(adapter);
    }
}


    private static String readURL(String theUrl) {
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(theUrl);
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString().trim();
    }
}


