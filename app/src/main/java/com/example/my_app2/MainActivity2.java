package com.example.my_app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    EditText lngth;
    EditText wt;
   RadioGroup ages;
   CheckBox ch_male,ch_female;
   Spinner spnr;
   Button btn2;
    ListView listview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn2=findViewById(R.id.btn_sbmt);

        String age=null;
        String item=null;
        String[] ListElements = new String[] {
                "station bike",
                "stair stepper",
                "rower",
                "cable and pully"
        };
        String[] ListElements1 = new String[] {
                "station bike",
                "stair stepper",
                "rower",

        };
        //fill list view
        listview = findViewById(R.id.listView1);
        final List<String> ListElementsArrayList = new ArrayList<>(Arrays.asList(ListElements));
        final ArrayAdapter<String> adapter = new ArrayAdapter<>
                (MainActivity2.this, android.R.layout.simple_list_item_1, ListElementsArrayList);
        listview.setAdapter(adapter);
        int number ;
        TextView textView = findViewById(R.id.txt_user);
        SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
        String value = sharedPreferences.getString("value"," ");
        number=sharedPreferences.getInt("count", 1);
        textView.setText(value);

        lngth=findViewById(R.id.length_user);
        wt=findViewById(R.id.wt_user);
        ages=findViewById(R.id.ages_users);
        ch_male=findViewById(R.id.chkmale);
        if(ch_male.isChecked()){
            final List<String> ListElementsArrayList1 = new ArrayList<>(Arrays.asList(ListElements1));
            final ArrayAdapter<String> adapter1 = new ArrayAdapter<>
                    (MainActivity2.this, android.R.layout.simple_list_item_1, ListElementsArrayList1);
            listview.setAdapter(adapter1);
        }else {
            final List<String> ListElementsArrayList2 = new ArrayList<>(Arrays.asList(ListElements));
            final ArrayAdapter<String> adapter2 = new ArrayAdapter<>
                    (MainActivity2.this, android.R.layout.simple_list_item_1, ListElementsArrayList2);
            listview.setAdapter(adapter2);
        }
        ch_female=findViewById(R.id.chkfemale);
        spnr=findViewById(R.id.days_train);


        int id  = ages.getCheckedRadioButtonId();
        if(id == R.id.less){
            //str+="\nFemale";
            age="less than 18";
        }
        else if(id == R.id.between){
            ///str+="\nMale";
            age="18 to 23";
        }
        else if(id == R.id.more){
            ///str+="\nMale";
            age="more than 23";
        }

        String gender = "";

        if(ch_male.isChecked()){
            gender="male";
        }
        if(ch_female.isChecked()){
            gender="female ";
        }
        populateSpinner();

        String finalAge = age;
        String finalGender = gender;
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String lngth_user=lngth.getText().toString();
                double Length_user=Double.parseDouble(lngth_user);
                double wet=Double.parseDouble(wt.getText().toString());
                String age_user= finalAge;
                String gender_user= finalGender;
                String spnr_item=spnr.getSelectedItem().toString();
                String item=" ";
                listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view,int position, long id) {

                       String  item = (String)listview.getItemAtPosition(position).toString();


                        //Log.i("Item", "Selected: " + item.getCentre());
                    }
                });

                ArrayList<gym_person> list=new ArrayList<>();
                gym_person gp=new gym_person(number,Length_user,wet, age_user, gender_user,spnr_item,item);
                list.add(gp);
               String result = gp.toString();

                SharedPreferences sharedPref = getSharedPreferences("myKey1", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();

                //use json library
                Gson gson=new Gson();
                String booksString = gson.toJson(list);
                editor.putString("value1", booksString);
                editor.apply();
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });




    }

    private void populateSpinner() {
        List<String> days = new ArrayList<>();
        days.add("monday");
        days.add("sunday");
        days.add("wednesday");
        days.add("thursday");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, days);
        spnr.setAdapter(adapter);

    }
}