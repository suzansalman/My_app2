package com.example.my_app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText user,pass;
    Button btn_login;
    private int number =0;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=findViewById(R.id.usr_txt);
        pass=findViewById(R.id.pass_txt);
        btn_login=findViewById(R.id.btn_login);
        txt=findViewById(R.id.txt_th);



        btn_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                number++;
                //String name_user=user.getText().toString();
                // SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
                // SharedPreferences.Editor editor = sharedPref.edit();
                //editor.putString("value", name_user);
                // editor.putInt("count",number);

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                String name_user=user.getText().toString();
                SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("value", name_user);
                intent.putExtra("count",number);
                editor.apply();
                startActivity(intent);

                Thread thread = new Thread(new MyTask(5));

                thread.start();
            }
        });

    }
    class MyTask implements Runnable{
        int seconds;

        public MyTask(int seconds){
            this.seconds = seconds;
        }
        @Override
        public void run() {

            for(int i = 0; i<seconds; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            txt.post(new Runnable() {
                @Override
                public void run() {
                    txt.setText("Done,.... ");
                }
            });
        }
    }

    public void btnFreez_Click(View view) {

        for(int i = 0; i< 5; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        txt.setText("Done freezing..");
    }


}