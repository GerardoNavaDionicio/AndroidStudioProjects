package com.example.appbiencce_oficial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
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

public class mantenimiento extends AppCompatActivity {
    RadioButton rb_mantenimiento_si,rb_mantenimiento_no;
    EditText edt_mantenimiento_id, edt_mantenimiento_nombre;

    Button pb_actualizar_mantenimiento,pb_consultar_mantenimiento,pb_eliminar_mantenimiento,pb_registrar_mantenimiento;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mantenimiento);
        rb_mantenimiento_no = (RadioButton) findViewById(R.id.rb_mantenimiento_si);
        rb_mantenimiento_si = (RadioButton) findViewById(R.id.rb_mantenimiento_no);

        edt_mantenimiento_id     = (EditText) findViewById(R.id.edt_mantenimiento_id);
        edt_mantenimiento_nombre = (EditText) findViewById(R.id.edt_mantenimiento_nombre);

        pb_registrar_mantenimiento  = (Button) findViewById(R.id.pb_registrar_mantenimiento);
        pb_consultar_mantenimiento  = (Button)findViewById(R.id.pb_consultar_mantenimiento);
        pb_actualizar_mantenimiento = (Button)findViewById(R.id.pb_actualizar_mantenimiento);
        pb_eliminar_mantenimiento   = (Button)findViewById(R.id.pb_eliminar_mantenimiento);
        pb_consultar_mantenimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscar("http://192.168.7.5/cursomovil/selectMante.php?id_mantenimiento="+edt_mantenimiento_id.getText()+"");
            }
        });
        pb_registrar_mantenimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar( "http://192.168.7.5/cursomovil/insertarMante.php");
            }
        });
        pb_actualizar_mantenimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actu("http://192.168.7.5/cursomovil/actualizarMante.php");
            }
        });
        pb_eliminar_mantenimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminar("http://192.168.7.5/cursomovil/eliminarMante.php");
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
                        edt_mantenimiento_nombre.setText(jsonObject.getString("nombre"));
                        Integer buscar=jsonObject.getInt("disponibilidad");
                        if (buscar==0)
                        {
                            rb_mantenimiento_si.setChecked(true);

                        }
                        else if (buscar==1)
                        {
                            rb_mantenimiento_no.setChecked(true);
                        }

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
                parametros.put("id_mantenimiento", edt_mantenimiento_id.getText().toString());
                edt_mantenimiento_id.setText("");
                edt_mantenimiento_nombre.setText("");
                rb_mantenimiento_no.setChecked(false);
                rb_mantenimiento_si.setChecked(false);
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
                String mant="";
                if(rb_mantenimiento_no.isChecked()){
                    mant="1";
                }
                else if(rb_mantenimiento_si.isChecked()){
                    mant="0";
                }
                Map<String, String> parametros  = new HashMap<String, String>();
                parametros.put("id_mantenimiento", edt_mantenimiento_id.getText().toString());
                parametros.put("nombre", edt_mantenimiento_nombre.getText().toString());
                parametros.put("disponibilidad", mant);
                edt_mantenimiento_id.setText("");
                edt_mantenimiento_nombre.setText("");
                rb_mantenimiento_no.setChecked(false);
                rb_mantenimiento_si.setChecked(false);
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
                String mant="";
                if(rb_mantenimiento_no.isChecked()){

                    mant="1";
                }
                else if(rb_mantenimiento_si.isChecked()){
                    mant="0";

                }
                Map<String, String> parametros  = new HashMap<String, String>();
                parametros.put("nombre", edt_mantenimiento_nombre.getText().toString());
                parametros.put("disponibilidad", mant);
                edt_mantenimiento_nombre.setText("");
                rb_mantenimiento_no.setChecked(false);
                rb_mantenimiento_si.setChecked(false);
                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}