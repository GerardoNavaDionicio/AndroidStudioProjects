package com.example.appbiencce_oficial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


public class fiesta extends AppCompatActivity {
    EditText edt_fiesta_id, edt_fiesta_tipo;
    Button pb_actualizar_fiesta,pb_consultar_fiesta,pb_eliminar_fiesta,pb_registrar_fiesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiesta);
        edt_fiesta_id        = (EditText)findViewById(R.id.edt_fiesta_id);
        edt_fiesta_tipo      = (EditText)findViewById(R.id.edt_fiesta_tipo);

        pb_registrar_fiesta  = (Button)findViewById(R.id.pb_registrar_fiesta);
        pb_consultar_fiesta  = (Button)findViewById(R.id.pb_consultar_fiesta);
        pb_actualizar_fiesta = (Button)findViewById(R.id.pb_actualizar_fiesta);
        pb_eliminar_fiesta   = (Button)findViewById(R.id.pb_eliminar_fiesta);
    }}