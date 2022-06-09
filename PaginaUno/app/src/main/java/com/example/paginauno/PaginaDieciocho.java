package com.example.paginauno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class PaginaDieciocho extends AppCompatActivity {
    Button pb,pb1,pb0;
    RadioButton op1,op2,op3,op4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_dieciocho);
        pb = (Button) findViewById(R.id.pb);
        op1=(RadioButton)findViewById(R.id.op1);
        op2=(RadioButton)findViewById(R.id.op2);
        op3=(RadioButton)findViewById(R.id.op3);
        op4=(RadioButton)findViewById(R.id.op4);
        pb1 = (Button) findViewById(R.id.pb1);
        pb0 = (Button) findViewById(R.id.pb0);
    }
    public void preguntaDiecinueve(View view)
    {
        if (op2.isChecked())
        {
            ImageView i=new ImageView(getApplicationContext());
            i.setImageResource(R.drawable.si);
            Toast toast = new Toast(getApplicationContext());
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(i);
            toast.show();

            Intent Diecinueve = new Intent(this,PaginaDiecinueve.class);
            startActivity(Diecinueve);
        }
        else
        {
            ImageView i=new ImageView(getApplicationContext());
            i.setImageResource(R.drawable.no);
            Toast toast = new Toast(getApplicationContext());
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(i);
            toast.show();
        }
    }
    public void Siguiente(View view)
    {
        Intent dos = new Intent(this,PaginaDiecinueve.class);
        startActivity(dos);
    }
    public void Volver(View view)
    {
        Intent dos = new Intent(this,PaginaDiecisiete.class);
        startActivity(dos);
    }
}