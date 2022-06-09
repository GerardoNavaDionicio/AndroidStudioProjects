package com.example.paginauno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class PaginaCinco extends AppCompatActivity {
    Button pb,pb1,pb0;
    RadioButton op1,op2,op3,op4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_cinco);
        pb = (Button) findViewById(R.id.pb);
        op1=(RadioButton)findViewById(R.id.op1);
        op2=(RadioButton)findViewById(R.id.op2);
        op3=(RadioButton)findViewById(R.id.op3);
        op4=(RadioButton)findViewById(R.id.op4);
        pb1 = (Button) findViewById(R.id.pb1);
        pb0 = (Button) findViewById(R.id.pb0);
    }
    public void preguntaSix(View view)
    {
        if (op1.isChecked())
        {
            ImageView i=new ImageView(getApplicationContext());
            i.setImageResource(R.drawable.si);
            Toast toast = new Toast(getApplicationContext());
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(i);
            toast.show();

            Intent seis = new Intent(this,PaginaSeis.class);
            startActivity(seis);
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
        Intent dos = new Intent(this,PaginaSeis.class);
        startActivity(dos);
    }
    public void Volver(View view)
    {
        Intent dos = new Intent(this,PaginaCuatro.class);
        startActivity(dos);
    }
}