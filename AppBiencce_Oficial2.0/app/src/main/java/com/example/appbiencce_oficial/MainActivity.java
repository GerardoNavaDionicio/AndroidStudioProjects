package com.example.appbiencce_oficial;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button pb_ingresar,pb_registrar,yessenia;
    EditText edt_usuario,edt_pass;
    String nombre,contraseña;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb_ingresar  = findViewById(R.id.pb_ingresar);
        pb_registrar = findViewById(R.id.pb_equipo);
        edt_pass=(EditText)findViewById(R.id.edt_pass);
        edt_usuario=(EditText) findViewById(R.id.edt_usuario);


        pb_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validadUsuario("http://192.168.67.82/cursomovil/validar.php");
            }
        });

    }

    private void validadUsuario(String URL)
    {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()){
                    Intent pagina = new Intent(getApplicationContext(),menu.class);
                    startActivity(pagina);
                }
                else{
                    Toast.makeText(MainActivity.this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>parametros=new HashMap<String,String>();
                parametros.put("nombre",edt_usuario.getText().toString());
                parametros.put("contraseña",edt_pass.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }


    public void registrar(View view)
    {
        Intent pagina = new Intent(this,registrar.class);
        startActivity(pagina);
    }
}