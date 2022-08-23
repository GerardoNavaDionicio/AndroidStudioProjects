package com.example.appbiencce_oficial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class produccion extends AppCompatActivity {
    EditText edt_produccion_id, edt_produccion_nombre,edt_produccion_transporte,edt_produccion_responsable;
    Button pb_actualizar_produccion,pb_consultar_produccion,pb_eliminar_produccion,pb_registrar_produccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produccion);

        edt_produccion_id          = (EditText)findViewById(R.id.edt_produccion_id);
        edt_produccion_nombre      = (EditText)findViewById(R.id.edt_produccion_nombre );
        edt_produccion_transporte  = (EditText)findViewById(R.id.edt_produccion_transporte);
        edt_produccion_responsable = (EditText)findViewById(R.id.edt_produccion_reponsable);

        pb_registrar_produccion  = (Button)findViewById(R.id.pb_registrar_produccion);
        pb_consultar_produccion  = (Button)findViewById(R.id.pb_consultar_produccion);
        pb_actualizar_produccion = (Button)findViewById(R.id.pb_actualizar_produccion);
        pb_eliminar_produccion   = (Button)findViewById(R.id.pb_eliminar_produccion);

    }
}