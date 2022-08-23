package com.example.appbiencce_oficial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class mantenimiento extends AppCompatActivity {
    RadioButton rb_mantenimiento_si,rb_mantenimiento_no;
    EditText edt_mantenimiento_id, edt_mantenimiento_nombre;

    Button pb_actualizar_mantenimiento,pb_consultar_mantenimiento,pb_eliminar_mantenimiento,pb_registrar_mantenimiento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mantenimiento);
        rb_mantenimiento_no = (RadioButton) findViewById(R.id.rb_mantenimiento_si);
        rb_mantenimiento_si = (RadioButton) findViewById(R.id.rb_mantenimiento_no);

        edt_mantenimiento_id     = (EditText) findViewById(R.id.edt_mantenimiento_id);
        edt_mantenimiento_nombre = (EditText) findViewById(R.id.edt_mantenimiento_nombre);

        pb_registrar_mantenimiento  = (Button) findViewById(R.id.pb_registrar_mantenimiento);
        pb_consultar_mantenimiento  = (Button)findViewById(R.id.pb_consultar_mantenimiento);
        pb_actualizar_mantenimiento = (Button)findViewById(R.id.pb_actualizar_mantenimiento);
        pb_eliminar_mantenimiento   = (Button)findViewById(R.id.pb_eliminar_mantenimiento);

    }
}