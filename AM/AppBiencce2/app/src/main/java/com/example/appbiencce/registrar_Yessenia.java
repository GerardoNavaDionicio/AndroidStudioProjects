package com.example.appbiencce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class registrar_Yessenia extends AppCompatActivity {
    EditText id, nombre, paterno, materno;
    Button btninsertar, btnbuscar, btnactualizar, btneliminar;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_yessenia);
    }
}