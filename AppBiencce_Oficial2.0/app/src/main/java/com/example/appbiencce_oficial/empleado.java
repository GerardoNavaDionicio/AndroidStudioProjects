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


public class empleado extends AppCompatActivity {
    RadioButton rb_femenino,rb_masculino;
    EditText edt_empleado_id, edt_empleado_nombre, edt_empleado_edad,edt_empleado_puesto;
    RequestQueue requestQueue;
    CharSequence valor;
    Button pb_actualizar_empleado,pb_consultar_empleado,pb_eliminar_empleado,pb_registrar_empleado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleado);
        rb_femenino  = (RadioButton)findViewById(R.id.rb_femenino);
        rb_masculino = (RadioButton)findViewById(R.id.rb_masculino);

        edt_empleado_id      = (EditText)findViewById(R.id.edt_empleado_id);
        edt_empleado_nombre  = (EditText)findViewById(R.id.edt_empleado_nombre);
        edt_empleado_edad    = (EditText)findViewById(R.id.edt_empleado_edad);
        edt_empleado_puesto  = (EditText)findViewById(R.id.edt_empleado_puesto);

        pb_registrar_empleado  = (Button)findViewById(R.id.pb_registrar_empleado);
        pb_consultar_empleado  = (Button)findViewById(R.id.pb_consultar_empleado);
        pb_actualizar_empleado = (Button)findViewById(R.id.pb_actualizar_empleado);
        pb_eliminar_empleado   = (Button)findViewById(R.id.pb_eliminar_empleado);

        pb_consultar_empleado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscar("http://192.168.7.5/cursomovil/selectEmp.php?id_empleado="+edt_empleado_id.getText()+"");
            }
        });
        pb_registrar_empleado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar( "http://192.168.7.5/cursomovil/insertarEmp.php");
            }
        });
        pb_actualizar_empleado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actu("http://192.168.7.5/cursomovil/actualizarEmp.php");
            }
        });
        pb_eliminar_empleado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminar("http://192.168.7.5/cursomovil/eliminarEmp.php");
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
                        edt_empleado_nombre.setText(jsonObject.getString("nombre"));
                        edt_empleado_edad.setText(jsonObject.getString("edad"));
                        edt_empleado_puesto.setText(jsonObject.getString("puesto"));
                        String sex=jsonObject.getString("genero");
                        String fem="F",masc="M";
                        if(sex.equals(fem))
                        {
                            rb_femenino.setChecked(true);
                        }
                        else if(sex.equals(masc))
                        {
                            rb_masculino.setChecked(true);
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
                parametros.put("id_empleado", edt_empleado_id.getText().toString());
                rb_masculino.setChecked(false);
                rb_femenino.setChecked(false);
                edt_empleado_nombre.setText("");
                edt_empleado_edad.setText("");
                edt_empleado_puesto.setText("");
                edt_empleado_id.setText("");
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
                String genero="";
                if(rb_femenino.isChecked()){
                    genero="F";
                }
                else if(rb_masculino.isChecked()){
                    genero="M";
                }
                Map<String, String> parametros  = new HashMap<String, String>();
                parametros.put("id_empleado", edt_empleado_id.getText().toString());
                parametros.put("nombre", edt_empleado_nombre.getText().toString());
                parametros.put("genero", genero);
                parametros.put("edad", edt_empleado_edad.getText().toString());
                parametros.put("puesto",edt_empleado_puesto.getText().toString());
                rb_masculino.setChecked(false);
                rb_femenino.setChecked(false);
                edt_empleado_nombre.setText("");
                edt_empleado_edad.setText("");
                edt_empleado_puesto.setText("");
                edt_empleado_id.setText("");
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
                String genero="";
                if(rb_femenino.isChecked()){
                    genero="F";
                }
                else if(rb_masculino.isChecked()){
                    genero="M";
                }
                Map<String, String> parametros  = new HashMap<String, String>();
                parametros.put("nombre", edt_empleado_nombre.getText().toString());
                parametros.put("genero", genero);
                parametros.put("edad", edt_empleado_edad.getText().toString());
                parametros.put("puesto",edt_empleado_puesto.getText().toString());
                rb_masculino.setChecked(false);
                rb_femenino.setChecked(false);
                edt_empleado_nombre.setText("");
                edt_empleado_edad.setText("");
                edt_empleado_puesto.setText("");
                edt_empleado_id.setText("");
                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}