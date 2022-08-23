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

public class produccion extends AppCompatActivity {
    EditText edt_produccion_id, edt_produccion_nombre,edt_produccion_transporte,edt_produccion_responsable;
    Button pb_actualizar_produccion,pb_consultar_produccion,pb_eliminar_produccion,pb_registrar_produccion;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produccion);

        edt_produccion_id          = (EditText)findViewById(R.id.edt_produccion_id);
        edt_produccion_nombre      = (EditText)findViewById(R.id.edt_produccion_nombre );
        edt_produccion_transporte  = (EditText)findViewById(R.id.edt_produccion_transporte);
        edt_produccion_responsable = (EditText)findViewById(R.id.edt_produccion_reponsable);

        pb_registrar_produccion  = (Button)findViewById(R.id.pb_registrar_produccion);
        pb_consultar_produccion  = (Button)findViewById(R.id.pb_consultar_produccion);
        pb_actualizar_produccion = (Button)findViewById(R.id.pb_actualizar_produccion);
        pb_eliminar_produccion   = (Button)findViewById(R.id.pb_eliminar_produccion);
        pb_consultar_produccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscar("http://192.168.67.82/cursomovil/selectProduc.php?id_produccion="+edt_produccion_id.getText()+"");
            }
        });
        pb_registrar_produccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar( "http://192.168.67.82/cursomovil/insertarProduc.php");
            }
        });
        pb_actualizar_produccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actu("http://192.168.67.82/cursomovil/actualizarProduc.php");
            }
        });
        pb_eliminar_produccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminar("http://192.168.67.82/cursomovil/eliminarProduc.php");
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
                        edt_produccion_nombre.setText(jsonObject.getString("nombre"));
                        edt_produccion_transporte.setText(jsonObject.getString("transporte"));
                        edt_produccion_responsable.setText(jsonObject.getString("responsable"));
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
                parametros.put("id_produccion", edt_produccion_id.getText().toString());
                return parametros;
            }
        };
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void actu(String URL){
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
                parametros.put("id_produccion", edt_produccion_id.getText().toString());
                parametros.put("nombre", edt_produccion_nombre.getText().toString());
                parametros.put("transporte", edt_produccion_transporte.getText().toString());
                parametros.put("responsable", edt_produccion_responsable.getText().toString());
                edt_produccion_id.setText("");
                edt_produccion_nombre.setText("");
                edt_produccion_responsable.setText("");
                edt_produccion_transporte.setText("");
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
                parametros.put("nombre", edt_produccion_nombre.getText().toString());
                parametros.put("transporte", edt_produccion_transporte.getText().toString());
                parametros.put("responsable", edt_produccion_responsable.getText().toString());
                edt_produccion_id.setText("");
                edt_produccion_nombre.setText("");
                edt_produccion_responsable.setText("");
                edt_produccion_transporte.setText("");
                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}