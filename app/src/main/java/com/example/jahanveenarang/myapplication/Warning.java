package com.example.jahanveenarang.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Warning extends AppCompatActivity {


    EditText editext1;
    EditText editText2;
    EditText editText3;

    String first , second , third ;

    Button save ;

    LinearLayout linearLayout ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warning);

        editext1 = findViewById(R.id.first);
        editText2 = findViewById(R.id.second);
        editText3= findViewById(R.id.third);

        linearLayout = findViewById(R.id.linear);
        save = findViewById(R.id.save);
        first = editext1.getText().toString();
        second = editText2.getText().toString();
        third  = editText3.getText().toString();

        if(first == null || second == null || third ==  null){

            Snackbar snackbar = Snackbar.make(linearLayout, "Fill the required fields", Snackbar.LENGTH_SHORT);
            snackbar.show();
        }
        else{

            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Intent intent = new Intent(getBaseContext(), Profile.class);
                    intent.putExtra("First Number", first);
                    intent.putExtra("Second Number", second);
                    intent.putExtra("Third Number", third);
                    startActivity(intent);

                    Intent i = new Intent(Warning.this , HomeActivity.class);
                    startActivity(i);
                    finish();
                }
            });
        }









    }
}