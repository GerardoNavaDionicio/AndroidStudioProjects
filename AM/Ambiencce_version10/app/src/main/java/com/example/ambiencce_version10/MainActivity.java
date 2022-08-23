package com.example.ambiencce_version10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button pb_empleados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb_empleados=(Button)findViewById(R.id.pb_empleados);
    }
    public void empleados(View view)
    {
        Intent empleados= new Intent(this,empleados.class);
        startActivity(empleados);
    }


}