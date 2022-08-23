package com.example.appbiencce_oficial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button pb_ingresar,pb_registrar,yessenia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yessenia = findViewById(R.id.yessenia);
        pb_ingresar  = findViewById(R.id.pb_ingresar);
        pb_registrar = findViewById(R.id.pb_equipo);

    }
    public void yessenia(View view)
    {
        Intent pagina = new Intent(this,registrar_Yessenia.class);
        startActivity(pagina);
    }
    public void menu(View view)
        {
            Intent pagina = new Intent(this,menu.class);
            startActivity(pagina);
        }
    public void registrar(View view)
    {
        Intent pagina = new Intent(this,registrar.class);
        startActivity(pagina);
    }
}