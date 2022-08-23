package com.example.appbiencce_oficial;

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

public class registrar extends AppCompatActivity {
    Button pb_registrar;
    EditText usuario,contra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        pb_registrar = (Button) findViewById(R.id.pb_equipo);
        usuario=(EditText)findViewById(R.id.edt_usuario);
        contra=(EditText)findViewById(R.id.edt_contraseña);
        pb_registrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ejecutar( "http://192.168.7.5/cursomovil/insertarAdmin.php");
            }
        });
    }


    public void ejecutar(String URL){
        Intent pagina = new Intent(this,MainActivity.class);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Registro creado exitosamente", Toast.LENGTH_LONG).show();
                startActivity(pagina);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }


        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros  = new HashMap<String, String>();
                parametros.put("nombre", usuario.getText().toString());
                parametros.put("contraseña", contra.getText().toString());

                return parametros;

            }




        };
        usuario.setText("");
        contra.setText("");
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


}