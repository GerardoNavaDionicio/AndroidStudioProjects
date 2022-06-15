package com.example.paginauno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class PaginaOnce extends AppCompatActivity {
    Button pb,pb1,pb0;
    CheckBox op1,op2,op3,op4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_once);
        op1= (CheckBox) findViewById(R.id.op1);
        op2=(CheckBox) findViewById(R.id.op2);
        op3=(CheckBox) findViewById(R.id.op3);
        op4=(CheckBox) findViewById(R.id.op4);
        pb1 = (Button) findViewById(R.id.pb1);
        pb0 = (Button) findViewById(R.id.pb0);
    }
    //Metodo para pasar Activity
    public void preguntaDoce(View view)
    {
        if ((op1.isChecked())&&op2.isChecked() && op3.isChecked()==false && op4.isChecked()==false)
        {
            ImageView i=new ImageView(getApplicationContext());
            i.setImageResource(R.drawable.si);
            Toast toast = new Toast(getApplicationContext());
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(i);
            toast.show();

            Intent dos = new Intent(this,PaginaDoce.class);
            startActivity(dos);
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
        Intent dos = new Intent(this,PaginaDoce.class);
        startActivity(dos);
    }
    public void Volver(View view)
    {
        Intent dos = new Intent(this,PaginaDiez.class);
        startActivity(dos);
    }
}