package com.example.calculadoracb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edt1, edt2;
    Button pb;
    TextView tv_res;
    CheckBox cb_suma,cb_resta,cb_multiplicacion,cb_division;
    Integer a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
        tv_res = (TextView) findViewById(R.id.tv_res);
        pb = (Button) findViewById(R.id.pb);
        cb_suma = (CheckBox) findViewById(R.id.cb_suma);
        cb_resta = (CheckBox) findViewById(R.id.cb_resta);
        cb_multiplicacion = (CheckBox) findViewById(R.id.cb_multiplicacion);
        cb_division = (CheckBox) findViewById(R.id.cb_division);

        pb.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                a=Integer.parseInt(edt1.getText().toString());
                b=Integer.parseInt(edt2.getText().toString());
                String resultado="";
                Integer suma1,resta1,multiplicacion1,division1;
                if (cb_suma.isChecked())
                {
                    suma1=a+b;
                    resultado="la suma es"+suma1;
                }
                if (cb_resta.isChecked())
                {
                    resta1=a-b;
                    resultado=resultado+"\n la resta es"+resta1;
                }
                if (cb_multiplicacion.isChecked())
                {
                    multiplicacion1=a*b;
                    resultado=resultado+"\n la Multiplicacion es"+multiplicacion1;
                }
                if (cb_division.isChecked())
                {
                    division1=a/b;
                    resultado=resultado+"\n la Division es"+division1;
                }






                tv_res.setText(resultado);






            }
        });
    }
    @Override
    public void onClick(View v) {}
}