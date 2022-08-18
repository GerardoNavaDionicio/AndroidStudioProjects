package com.example.appbiencce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void gesempleados(View view)
    {
        Intent nueva = new Intent(this,gestionarEmpleadosAdmin.class);
        startActivity(nueva);
    }
    public void gesequipo(View view)
    {
        Intent nueva = new Intent(this,gestionarEquipo.class);
        startActivity(nueva);
    }
    public void gesevento(View view)
    {
        Intent nueva = new Intent(this,gestionarEvento.class);
        startActivity(nueva);
    }
    public void gesfiesta(View view)
    {
        Intent nueva = new Intent(this,gestionarfiesta.class);
        startActivity(nueva);
    }
    public void gemant(View view)
    {
        Intent nueva = new Intent(this,gestionarMantenimiento.class);
        startActivity(nueva);
    }
    public void gespro(View view)
    {
        Intent nueva = new Intent(this,gestionarProduccion.class);
        startActivity(nueva);
    }
}