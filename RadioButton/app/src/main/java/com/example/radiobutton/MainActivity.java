package com.example.radiobutton;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity implements View.OnClickListener {
    EditText edt1, edt2;
    RadioButton rb1, rb2;
    Button pb;
    TextView tv_res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
        tv_res = (TextView) findViewById(R.id.tv_res);
        pb = (Button) findViewById(R.id.pb);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);

        if (rb1.isChecked()) {
            pb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tv_res.setText(suma(Integer.parseInt(edt1.getText().toString()), Integer.parseInt(edt2.getText().toString())) + "");
                }
            });

        } else {
            {
                pb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tv_res.setText(resta(Integer.parseInt(edt1.getText().toString()), Integer.parseInt(edt2.getText().toString())) + "");
                    }
                });
            }

        }
    }
    public int suma(int a, int b)
    {
        return a+b;
    }
    public int resta(int a, int b)
    {
        return a-b;
    }