package com.example.appbiencce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button pb_registrar,pb_ingresar;
    TextView edt_usuario,edt_contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb_ingresar=findViewById(R.id.pb_ingresar);
        pb_ingresar=findViewById(R.id.pb_registrar):
    }
}