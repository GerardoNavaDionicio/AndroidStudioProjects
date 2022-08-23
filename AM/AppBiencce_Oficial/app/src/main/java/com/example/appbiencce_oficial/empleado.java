package com.example.appbiencce_oficial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;



public class empleado extends AppCompatActivity {
    RadioButton rb_femenino,rb_masculino;
    EditText edt_empleado_id, edt_empleado_nombre, edt_empleado_edad,edt_empleado_puesto;

    Button pb_actualizar_empleado,pb_consultar_empleado,pb_eliminar_empleado,pb_registrar_empleado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleado);
        rb_femenino  = (RadioButton)findViewById(R.id.rb_femenino);
        rb_masculino = (RadioButton)findViewById(R.id.rb_masculino);

        edt_empleado_id      = (EditText)findViewById(R.id.edt_empleado_id);
        edt_empleado_nombre  = (EditText)findViewById(R.id.edt_empleado_nombre);
        edt_empleado_edad    = (EditText)findViewById(R.id.edt_empleado_edad);
        edt_empleado_puesto  = (EditText)findViewById(R.id.edt_empleado_puesto);

        pb_registrar_empleado  = (Button)findViewById(R.id.pb_registrar_empleado);
        pb_consultar_empleado  = (Button)findViewById(R.id.pb_consultar_empleado);
        pb_actualizar_empleado = (Button)findViewById(R.id.pb_actualizar_empleado);
        pb_eliminar_empleado   = (Button)findViewById(R.id.pb_eliminar_empleado);




    }
}