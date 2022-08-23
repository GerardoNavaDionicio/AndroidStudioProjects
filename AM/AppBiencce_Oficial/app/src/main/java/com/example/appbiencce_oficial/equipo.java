package com.example.appbiencce_oficial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class equipo extends AppCompatActivity {
    RadioButton rb_equipo_si,rb_equipo_no;
    EditText edt_equipo_id, edt_equipo_nombre, edt_equipo_marca,edt_equipo_descripcion,edt_equipo_cantidad;

    Button pb_actualizar_equipo,pb_consultar_equipo,pb_eliminar_equipo,pb_registrar_equipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipo);

        rb_equipo_no = (RadioButton) findViewById(R.id.rb_equipo_si);
        rb_equipo_si = (RadioButton) findViewById(R.id.rb_equipo_no);



        edt_equipo_id          = (EditText)findViewById(R.id.edt_equipo_id);
        edt_equipo_nombre      = (EditText)findViewById(R.id.edt_equipo_nombre);
        edt_equipo_marca       = (EditText)findViewById(R.id.edt_equipo_marca);
        edt_equipo_descripcion = (EditText)findViewById(R.id.edt_equipo_descripcion);
        edt_equipo_cantidad    = (EditText)findViewById(R.id.edt_equipo_cantidad);




        pb_registrar_equipo  = (Button)findViewById(R.id.pb_registrar_equipo);
        pb_consultar_equipo  = (Button)findViewById(R.id.pb_consultar_equipo);
        pb_actualizar_equipo = (Button)findViewById(R.id.pb_actualizar_equipo);
        pb_eliminar_equipo   = (Button)findViewById(R.id.pb_eliminar_equipo);

    }
}