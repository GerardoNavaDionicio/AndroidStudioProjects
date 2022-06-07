package com.example.calificaciones;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edt1,edt2,edt3,edt4,edt5;
    Button pb_promedio;
    int total,a,b,c,d,e;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1=(EditText)findViewById(R.id.edt1);
        edt2=(EditText)findViewById(R.id.edt2);
        edt3=(EditText)findViewById(R.id.edt3);
        edt4=(EditText)findViewById(R.id.edt4);
        edt5=(EditText)findViewById(R.id.edt5);
        pb_promedio=(Button) findViewById(R.id.pb_promedio);
        pb_promedio.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        a = Integer.parseInt(edt1.getText().toString());
        b = Integer.parseInt(edt2.getText().toString());
        c = Integer.parseInt(edt3.getText().toString());
        d = Integer.parseInt(edt4.getText().toString());
        e = Integer.parseInt(edt5.getText().toString());
        total= (a+b+c+d+e)/5;

        if (total>=7)
        {
            Toast.makeText(this, "Aprobado", Toast.LENGTH_SHORT).show();

        }
        else
        {
            Toast.makeText(this, "Reprobado", Toast.LENGTH_SHORT).show();
        }
    }
}