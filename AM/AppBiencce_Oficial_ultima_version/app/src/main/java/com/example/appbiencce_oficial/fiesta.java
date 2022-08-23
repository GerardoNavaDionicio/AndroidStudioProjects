package com.example.appbiencce_oficial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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


public class fiesta extends AppCompatActivity {
    EditText edt_fiesta_id, edt_fiesta_tipo;
    Button pb_actualizar_fiesta,pb_consultar_fiesta,pb_eliminar_fiesta,pb_registrar_fiesta;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiesta);
        edt_fiesta_id        = (EditText)findViewById(R.id.edt_fiesta_id);
        edt_fiesta_tipo      = (EditText)findViewById(R.id.edt_fiesta_tipo);

        pb_registrar_fiesta  = (Button)findViewById(R.id.pb_registrar_fiesta);
        pb_consultar_fiesta  = (Button)findViewById(R.id.pb_consultar_fiesta);
        pb_actualizar_fiesta = (Button)findViewById(R.id.pb_actualizar_fiesta);
        pb_eliminar_fiesta   = (Button)findViewById(R.id.pb_eliminar_fiesta);


        pb_consultar_fiesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscar("http://192.168.7.5/cursomovil/selectFies.php?id_fiesta="+edt_fiesta_id.getText()+"");
            }
        });
        pb_registrar_fiesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar( "http://192.168.7.5/cursomovil/insertarFies.php");
            }
        });
        pb_actualizar_fiesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizar("http://192.168.7.5/cursomovil/actualizarFies.php");
            }
        });
        pb_eliminar_fiesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminar("http://192.168.7.5/cursomovil/eliminarFies.php");
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
                        edt_fiesta_tipo.setText(jsonObject.getString("tipo_de_fiesta"));
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
                parametros.put("id_fiesta", edt_fiesta_id.getText().toString());
                edt_fiesta_id.setText("");
                edt_fiesta_tipo.setText("");
                return parametros;
            }
        };
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void actualizar(String URL){
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
                String genero="";
                Map<String, String> parametros  = new HashMap<String, String>();
                parametros.put("id_fiesta", edt_fiesta_id.getText().toString());
                parametros.put("tipo_de_fiesta", edt_fiesta_tipo.getText().toString());
                edt_fiesta_id.setText("");
                edt_fiesta_tipo.setText("");
                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    public void registrar(String URL){
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
                parametros.put("tipo_de_fiesta", edt_fiesta_tipo.getText().toString());
                edt_fiesta_id.setText("");
                edt_fiesta_tipo.setText("");
                return parametros;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}