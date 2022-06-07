package com.example.calculadorarb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edt1, edt2;
    Button pb;
    TextView tv_res;
    RadioButton rb_suma,rb_resta,rb_multiplicacion,rb_division;
    int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
        tv_res = (TextView) findViewById(R.id.tv_res);
        pb = (Button) findViewById(R.id.pb);
        rb_suma = (RadioButton) findViewById(R.id.rb_suma);
        rb_resta = (RadioButton) findViewById(R.id.rb_resta);
        rb_multiplicacion = (RadioButton) findViewById(R.id.rb_multiplicacion);
        rb_division = (RadioButton) findViewById(R.id.rb_division);

        pb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=Integer.parseInt(edt2.getText().toString());
                if (rb_suma.isChecked())
                {
                    tv_res.setText (suma(Integer.parseInt(edt1.getText().toString()),Integer.parseInt(edt2.getText().toString()))+"");
                }
                else if (rb_resta.isChecked())
                {
                    tv_res.setText (resta(Integer.parseInt(edt1.getText().toString()),Integer.parseInt(edt2.getText().toString()))+"");
                }
                else if (rb_multiplicacion.isChecked())
                {
                    tv_res.setText (multiplicacion(Integer.parseInt(edt1.getText().toString()),Integer.parseInt(edt2.getText().toString()))+"");
                }
                else if (rb_division.isChecked() && a!=0)
                {
                    tv_res.setText (division(Integer.parseInt(edt1.getText().toString()),Integer.parseInt(edt2.getText().toString()))+"");
                }
                else
                {
                    tv_res.setText ("no existe la division entre 0");
                }
            }
        });
    }

    public int suma(int a, int b)
    {
        return a+b;
    }
    public int resta(int a, int b)
    {
        return a-b;
    }
    public int multiplicacion(int a, int b)
    {
        return a*b;
    }
    public int division(int a, int b){return a-b;}

    @Override
    public void onClick(View v) {}
}
