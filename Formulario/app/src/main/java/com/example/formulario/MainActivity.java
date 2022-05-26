package com.example.formulario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edt_nombre;
    EditText edt_correo;
    String a,b;
    Button pb_acceder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_nombre=(EditText)findViewById(R.id.edt_nombre);
        edt_correo=(EditText)findViewById(R.id.edt_correo);
        pb_acceder=(Button) findViewById(R.id.pb_acceder);

        pb_acceder.setOnClickListener(this);


    }

        @Override
        public void  onClick(View V)
        {
            a = edt_nombre.getText().toString();
            b = edt_correo.getText().toString();

            Toast.makeText(this, "Nombre"+a+"\n Correo:"+b, Toast.LENGTH_SHORT).show();
    }



}