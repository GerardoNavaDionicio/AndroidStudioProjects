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
        String[] opciones={"SUMA","RESTA","MULTIPLICACIÓN","DIVISION"};

        ArrayAdapter<String> adapter=new ArrayAdapter <String> (this, android.R.layout.simple_spinner_item,opciones);
        spinner.setAdapter(adapter);
    }



    @Override
    public void onClick(View v) {
    float v1,v2;
    v1=Float.parseFloat(edt1.getText().toString());
    v2=Float.parseFloat(edt2.getText().toString());
    String seleccion=spinner.getSelectedItem().toString();

    if (seleccion.equals("SUMA")){
        float sum;
        sum=v1+v2;
        tv_res.setText("El resultado de la suma es:"+sum);
    }

    else if (seleccion.equals("RESTA")){
        float resultado;
        resultado=v1-v2;
        tv_res.setText("El resultado de la suma es:"+resultado);
    }

    else if (seleccion.equals("MULTIPLICACIÓN")){
        float resultado;
        resultado=v1*v2;
        tv_res.setText("El resultado de la suma es:"+resultado);
    }

    else if ((seleccion.equals("DIVISION")) && v2!=0){
        float resultado;
        resultado=v1/v2;
        tv_res.setText("El resultado de la suma es:"+resultado);
    }

    else{
        tv_res.setText("No hay division entre ceros");

    }
    }
}