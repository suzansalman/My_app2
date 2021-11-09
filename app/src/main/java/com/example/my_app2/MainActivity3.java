package com.example.my_app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class MainActivity3 extends AppCompatActivity {
    TextView tv_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tv_item=findViewById(R.id.items);
        SharedPreferences prefs2 = getSharedPreferences("myKey1", MODE_PRIVATE);
      //  String value = prefs2.getString("value1"," ");

       // SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();
        String str = prefs2.getString("value1", "");
        gym_person[] books = gson.fromJson(str, gym_person[].class);

        //number=sharedPreferences.getInt("count", Integer.parseInt(" "));
        for(int i=0;i<books.length;i++){
            tv_item.setText(books[i].toString());
        }

    }
}