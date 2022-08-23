package com.example.appbiencce_oficial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu extends AppCompatActivity {
    Button pb_empleado,pb_equipo,pb_evento,pb_fiesta,pb_mantenimiento,pb_produccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        pb_empleado      = (Button) findViewById(R.id.pb_empleado);
        pb_equipo        = (Button)findViewById(R.id.pb_equipo);
        pb_evento        = (Button)findViewById(R.id.pb_evento);
        pb_fiesta        = (Button)findViewById(R.id.pb_fiesta);
        pb_mantenimiento = (Button) findViewById(R.id.pb_mantenmiento);
        pb_produccion    = (Button) findViewById(R.id.pb_produccon);
    }
    public void empleados(View view)
    {
        Intent pagina = new Intent(this,empleado.class);
        startActivity(pagina);
    }
    public void equipo(View view)
    {
        Intent pagina = new Intent(this,equipo.class);
        startActivity(pagina);
    }
    public void evento(View view)
    {
        Intent pagina = new Intent(this,evento.class);
        startActivity(pagina);
    }
    public void fiesta(View view)
    {
        Intent pagina = new Intent(this,fiesta.class);
        startActivity(pagina);
    }
    public void mantenimiento(View view)
    {
        Intent pagina = new Intent(this,mantenimiento.class);
        startActivity(pagina);
    }
    public void produccion(View view)
    {
        Intent pagina = new Intent(this,produccion.class);
        startActivity(pagina);
    }
}