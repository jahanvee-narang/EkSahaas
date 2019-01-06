package com.example.jahanveenarang.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity {


    TextView tvfirst ,tvsecond , tvthird ;
    String first , second , third ;
    Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvfirst = findViewById(R.id.firstnumber);
        tvsecond = findViewById(R.id.secondnumber);
        tvthird = findViewById(R.id.thirdnumber);
        update = findViewById(R.id.update);
        Intent intent = getIntent();
         first = intent.getStringExtra("First Number");
        second = intent.getStringExtra("Second Number");
        third = intent.getStringExtra("Third Number");

        tvfirst.setText(first);
        tvsecond.setText(second);
        tvthird.setText(third);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Profile.this , Warning.class);
                startActivity(i);
            }
        });


    }


}
