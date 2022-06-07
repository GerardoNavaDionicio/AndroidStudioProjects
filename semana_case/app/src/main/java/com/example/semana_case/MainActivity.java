package com.example.semana_case;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edt1,edt2,edt3,edt4,edt5;
        Button pb_dia;
        edt1=(EditText)findViewById(R.id.edt1);
        pb_dia=(Button) findViewById(R.id.pb_dia);
    }
    @Override
    public void onClick(View v)
    {

    }

}