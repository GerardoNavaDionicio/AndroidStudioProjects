package com.example.diaspaises;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner select_dias,select_paises;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner sp_dias= (Spinner) findViewById(R.id.sp_dias);
        Spinner sp_paises= (Spinner) findViewById(R.id.sp_paises);

        String[] dias={"LUNES","MARTES"};
        String[] paises={"MÉXICO","BRASIL"};

        ArrayAdapter<String> dia = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dias);
        ArrayAdapter<String> pais = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, paises);

        sp1.setAdapter(dia);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

        }
    }

}
