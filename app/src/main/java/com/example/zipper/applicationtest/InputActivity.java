package com.example.zipper.applicationtest;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import Model.DataBase;
import Model.DataBaseControl;
import Model.ListViewAdapter;

public class InputActivity extends AppCompatActivity  {
    public Button saveButton;
    EditText nameEdit,ageEdit;
    private DataBaseControl dbCon;
    DataBase dataBase;
   ArrayList<DataBase> DataList=new ArrayList<>();

    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dbCon = new DataBaseControl(this);

        saveButton = (Button) findViewById(R.id.addButton);
        nameEdit = (EditText) findViewById(R.id.editName);
        ageEdit = (EditText) findViewById(R.id.editAge);
        listView = (ListView) findViewById(R.id.lol);
        dbCon = new DataBaseControl(this);
        dbCon = new DataBaseControl(this);
        DataList = new ArrayList<>();
        final Cursor data = dbCon.getListContents();
        int numRows = data.getCount();
        if (numRows == 0) {
            Toast.makeText(InputActivity.this, "The Database is empty ", Toast.LENGTH_LONG).show();
        } else {
            int i = 0;
            while (data.moveToNext()) {
                dataBase = new DataBase(data.getString(1), data.getString(2));
                DataList.add(i,dataBase);
                i++;
            }
            ListViewAdapter adapter = new ListViewAdapter(this, R.layout.list_data,DataList);
            listView = (ListView) findViewById(R.id.lol);
            listView.setAdapter(adapter);
     }
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = String.valueOf(nameEdit.getText());
                String Age = String.valueOf(ageEdit.getText());

                if (Name.length() != 0 && Age.length() != 0) {
                    AddData(Name, Age);

                    nameEdit.setText("");
                    nameEdit.setHint("กรอกชื่อ");
                    ageEdit.setText("");
                    ageEdit.setHint("กรอกอายุ");

                    reloadingDatabase();

                } else {
                    Toast.makeText(InputActivity.this, "กรุณากรอกข้อมูล !!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void AddData(String Name,String Age ){
        boolean insertData = dbCon.addData(Name,Age);

        if(insertData==true){
            Toast.makeText(InputActivity.this,"เพิ่ม "+Name+" เเล้ว",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(InputActivity.this,"ลองอีกครั้ง",Toast.LENGTH_LONG).show();
        }
    }

    public void reloadingDatabase() {
        final Cursor data = dbCon.getListContents();
        int i = 0;
        DataList.clear();
        while (data.moveToNext()) {
            dataBase = new DataBase(data.getString(1), data.getString(2));
            DataList.add(i,dataBase);
            i++;
        }
        ListViewAdapter adapter = new ListViewAdapter(this, R.layout.list_data,DataList);
        listView = (ListView) findViewById(R.id.lol);
        listView.setAdapter(adapter);
    }


}