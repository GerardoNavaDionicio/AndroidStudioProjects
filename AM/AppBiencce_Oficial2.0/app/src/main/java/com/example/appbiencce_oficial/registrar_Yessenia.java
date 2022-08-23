package com.example.appbiencce_oficial;

import androidx.appcompat.app.AppCompatActivity;

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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class registrar_Yessenia extends AppCompatActivity {
    EditText id, nombre, paterno, materno;
    Button btninsertar, btnbuscar, btnactualizar, btneliminar;
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_yessenia);

        id = (EditText)findViewById(R.id.id);
        nombre = (EditText)findViewById(R.id.name);
        paterno = (EditText)findViewById(R.id.apep);
        materno = (EditText)findViewById(R.id.apem);
        btnbuscar = (Button)findViewById(R.id.btnbus);


        btnbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscar("http://192.168.1.75/cursomovil/select.php?id="+id.getText()+"");
            }
        });
        btninsertar = (Button)findViewById(R.id.btnC);
        btninsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecutar( "http://192.168.1.75/cursomovil/insertar.php");
            }
        });
        btnactualizar = (Button)findViewById(R.id.btnact);
        btnactualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecutarservicio("http://192.168.1.75/cursomovil/actualizar.php");
            }
        });
        btneliminar= (Button)findViewById(R.id.btneli);
        btneliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminar("http://192.168.1.75/cursomovil/eliminar.php");
            }
        });

    }
    private void buscar(String URL){
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        nombre.setText(jsonObject.getString("nombre"));
                        paterno.setText(jsonObject.getString("apellido_p"));
                        materno.setText(jsonObject.getString("apellido_m"));
                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "No se encontró el registro", Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

    private void eliminar(String URL){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Eliminación exitosa", Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros=new HashMap<String, String>();
                parametros.put("id", id.getText().toString());
                return parametros;
            }
        };
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void ejecutarservicio(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Actualización exitosa", Toast.LENGTH_LONG).show();

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
                parametros.put("id", id.getText().toString());
                parametros.put("nombre", nombre.getText().toString());
                parametros.put("apellido_p", paterno.getText().toString());
                parametros.put("apellido_m", materno.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    public void ejecutar(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Registro creado exitosamente", Toast.LENGTH_LONG).show();

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
                parametros.put("nombre", nombre.getText().toString());
                parametros.put("apellido_p", paterno.getText().toString());
                parametros.put("apellido_m", materno.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}