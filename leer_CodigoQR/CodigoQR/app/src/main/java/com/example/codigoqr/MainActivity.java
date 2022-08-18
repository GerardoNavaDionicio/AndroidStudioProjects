package com.example.codigoqr;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button pb_qr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb_qr=findViewById(R.id.pb_qr);
    }
    public void qr(View view)
    {
        Intent pagina = new Intent(this,leer_qr.class);
        startActivity(pagina);
    }

}