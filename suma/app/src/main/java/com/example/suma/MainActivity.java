package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.suma.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edt1,edt2;
    Button pb_sumar;
    TextView tv_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1=(EditText)findViewById(R.id.edt1);
        edt2=(EditText)findViewById(R.id.edt2);
        tv_resultado=(TextView)findViewById(R.id.tv_resultado);
        pb_sumar=(Button)findViewById(R.id.pb_sumar);
        pb_sumar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        float b,a,c;
        a=Float.parseFloat(edt1.getText().toString());
        b=Float.parseFloat(edt2.getText().toString());
        c=a+b;
        tv_resultado.setText((int) c);
    }
}