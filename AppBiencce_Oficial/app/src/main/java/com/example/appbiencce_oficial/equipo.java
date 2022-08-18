package com.example.appbiencce_oficial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class equipo extends AppCompatActivity {
    RadioButton rb_equipo_si,rb_equipo_no;
    EditText edt_equipo_id, edt_equipo_nombre, edt_equipo_marca,edt_equipo_descripcion,edt_equipo_cantidad;

    Button pb_actualizar_equipo,pb_consultar_equipo,pb_eliminar_equipo,pb_registrar_equipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipo);
        rb_equipo_no  = findViewById(R.id.rb_equipo_si);
        rb_equipo_si = findViewById(R.id.rb_equipo_no);



        edt_equipo_id = findViewById(R.id.edt_equipo_id);
        edt_equipo_nombre = findViewById(R.id.edt_equipo_nombre);
        edt_equipo_marca = findViewById(R.id.edt_equipo_marca);
        edt_equipo_descripcion =findViewById(R.id.edt_equipo_descripcion);
        edt_equipo_cantidad = findViewById(R.id.edt_equipo_cantidad);




        pb_registrar_equipo  = findViewById(R.id.pb_registrar_equipo);
        pb_consultar_equipo  = findViewById(R.id.pb_consultar_equipo);
        pb_actualizar_equipo = findViewById(R.id.pb_actualizar_equipo);
        pb_eliminar_equipo   = findViewById(R.id.pb_eliminar_equipo);

    }
}