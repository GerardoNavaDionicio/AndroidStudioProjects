package com.example.calculadoraspinner;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edt1, edt2;
    Button pb;
    TextView tv_res;
    Spinner spinner;
    String[] opciones={"suma","resta","multiplicacion","division"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
        tv_res = (TextView) findViewById(R.id.tv_res);
        pb = (Button) findViewById(R.id.pb);
        spinner = (Spinner) findViewById(R.id.spinner);
        pb.setOnClickListener(this);
        String[] opciones={"suma","resta","multiplicacion","division"};
    }
    ArrayAdapter<String>adapter=new ArrayAdapter<String>(Context:this,android.R.layout.simple.spinning);




    @Override
    public void onClick(View v) {

    }
}