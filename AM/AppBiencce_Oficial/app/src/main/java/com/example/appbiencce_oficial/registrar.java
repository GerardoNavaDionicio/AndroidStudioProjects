package com.example.appbiencce_oficial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class registrar extends AppCompatActivity {
    Button pb_registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        pb_registrar = (Button) findViewById(R.id.pb_equipo);
    }
    public void login(View view)
    {
        Intent pagina = new Intent(this,MainActivity.class);
        startActivity(pagina);
    }
}