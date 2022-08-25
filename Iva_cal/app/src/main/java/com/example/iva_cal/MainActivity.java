package com.example.iva_cal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edt_n;
    Button pb_calcular;
    float a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_n = (EditText) findViewById(R.id.edt_n);
        pb_calcular = (Button) findViewById(R.id.pb_calcular);
    }

    public void iva (View view)
    {
        a=Integer.parseInt(edt_n.getText().toString());
        c = (float) 0.16;
        edt_n.setText("Total:"+(a*c)+a);
    }

}