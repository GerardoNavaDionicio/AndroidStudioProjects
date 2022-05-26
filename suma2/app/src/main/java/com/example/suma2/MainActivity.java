package com.example.suma2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edt1,edt2;
    Button pb_sumar,pb_restar,pb_multiplicar,pb_dividir;
    TextView tv_res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1=(EditText)findViewById(R.id.edt1);
        edt2=(EditText)findViewById(R.id.edt2);
        tv_res=(TextView)findViewById(R.id.tv_res);
        pb_sumar=(Button)findViewById(R.id.pb_sumar);
        pb_restar =(Button)findViewById(R.id.pb_restar);
        pb_multiplicar=(Button)findViewById(R.id.pb_multiplicar);
        pb_dividir=(Button)findViewById(R.id.pb_dividir);


        pb_sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_res.setText (suma(Integer.parseInt(edt1.getText().toString()),Integer.parseInt(edt2.getText().toString()))+"");
            }
        });

        pb_restar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_res.setText (resta(Integer.parseInt(edt1.getText().toString()),Integer.parseInt(edt2.getText().toString()))+"");
            }
        });

        pb_multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_res.setText (multiuplicacion(Integer.parseInt(edt1.getText().toString()),Integer.parseInt(edt2.getText().toString()))+"");
            }
        });

        pb_dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_res.setText (division(Integer.parseInt(edt1.getText().toString()),Integer.parseInt(edt2.getText().toString()))+"");
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
    public int multiuplicacion(int a, int b)
    {
        return a*b;
    }
    public int division(int a, int b)
    {
        return a/b;
    }


}