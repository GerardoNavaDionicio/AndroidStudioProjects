package com.example.segundo__crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class login extends AppCompatActivity {
    Button pb_registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        pb_registrar=findViewById(R.id.pb_registrar);

    }
    public void ejemplo(View view)
    {
        Intent dos = new Intent(this,crud_Ejemplo.class);
        startActivity(dos);
    }
}