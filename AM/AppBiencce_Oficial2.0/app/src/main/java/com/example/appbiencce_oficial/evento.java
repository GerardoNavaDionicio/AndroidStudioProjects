package com.example.appbiencce_oficial;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
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

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class evento extends AppCompatActivity implements View.OnClickListener {
    EditText edt_evento_id, edt_evento_lugar,edt_evento_hora_inicio,edt_evento_hora_fin,edt_evento_fecha;
    Button pb_actualizar_evento,pb_consultar_evento,pb_eliminar_evento,pb_registrar_evento,pb_evento_hora_inicio,pb_evento_hora_fin,pb_evento_fecha;
    RequestQueue requestQueue;
    private int año, mes, dia, hora, minutos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);
        edt_evento_id          = (EditText)findViewById(R.id.edt_evento_id);
        edt_evento_lugar       = (EditText)findViewById(R.id.edt_evento_lugar);
        edt_evento_hora_inicio = (EditText)findViewById(R.id.edt_evento_hora_inicio);
        edt_evento_hora_fin    = (EditText)findViewById(R.id.edt_evento_hora_fin);
        edt_evento_fecha       = (EditText)findViewById(R.id.edt_evento_fecha);


        pb_evento_hora_inicio = (Button)findViewById(R.id.pb_evento_hora_incio);
        pb_evento_hora_fin    = (Button)findViewById(R.id.pb_evento_hora_fin);
        pb_evento_fecha       = (Button)findViewById(R.id.pb_evento_fecha);

        pb_registrar_evento  = (Button)findViewById(R.id.pb_registrar_evento);
        pb_consultar_evento  = (Button)findViewById(R.id.pb_consultar_evento);
        pb_actualizar_evento = (Button)findViewById(R.id.pb_actualizar_evento);
        pb_eliminar_evento   = (Button)findViewById(R.id.pb_eliminar_evento);

        pb_evento_hora_inicio.setOnClickListener(this);
        pb_evento_hora_fin.setOnClickListener(this);
        pb_evento_fecha.setOnClickListener(this);

        pb_consultar_evento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscar("http://192.168.7.5/cursomovil/selectEven.php?id_evento="+edt_evento_id.getText()+"");
            }
        });
        pb_registrar_evento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar( "http://192.168.7.5/cursomovil/insertarEven.php");
            }
        });
        pb_actualizar_evento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actu("http://192.168.7.5/cursomovil/actualizarEven.php");
            }
        });
        pb_eliminar_evento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminar("http://192.168.7.5/cursomovil/eliminarEven.php");
            }
        });
    }

    //@RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v)
    {
        if (v==pb_evento_fecha)
        {
            final Calendar c=Calendar.getInstance();
            dia=c.get(Calendar.DAY_OF_MONTH);
            mes=c.get(Calendar.MONTH);
            año=c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    //edt_evento_fecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                    edt_evento_fecha.setText(year+"-"+(month+1)+"-"+dayOfMonth);
                }
            },dia,mes,año);
            datePickerDialog.show();
        }
        if (v==pb_evento_hora_inicio)
        {
            final Calendar c=Calendar.getInstance();
            hora=c.get(Calendar.HOUR_OF_DAY);
            minutos=c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    edt_evento_hora_inicio.setText(hourOfDay+":"+minute);
                }
            },hora,minutos,false);
            timePickerDialog.show();
        }
        if(v==pb_evento_hora_fin)
        {
            final Calendar c=Calendar.getInstance();
            hora=c.get(Calendar.HOUR_OF_DAY);
            minutos=c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    edt_evento_hora_fin.setText(hourOfDay+":"+minute);
                }
            },hora,minutos,false);
            timePickerDialog.show();
        }
    }
    private void buscar(String URL){
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        edt_evento_fecha.setText(jsonObject.getString("fecha"));
                        edt_evento_hora_inicio.setText(jsonObject.getString("hora_inicio"));
                        edt_evento_hora_fin.setText(jsonObject.getString("hora_fin"));
                        edt_evento_lugar.setText(jsonObject.getString("lugar"));
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
                parametros.put("id_evento", edt_evento_id.getText().toString());
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
                parametros.put("id_evento", edt_evento_id.getText().toString());
                parametros.put("fecha", edt_evento_fecha.getText().toString());
                parametros.put("hora_inicio", edt_evento_hora_inicio.getText().toString());
                parametros.put("hora_fin", edt_evento_hora_fin.getText().toString());
                parametros.put("lugar",edt_evento_lugar.getText().toString());
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
                parametros.put("fecha", edt_evento_fecha.getText().toString());
                parametros.put("hora_inicio", edt_evento_hora_inicio.getText().toString());
                parametros.put("hora_fin", edt_evento_hora_fin.getText().toString());
                parametros.put("lugar",edt_evento_lugar.getText().toString());
                return parametros;
            }
        };
        edt_evento_fecha.setText("");
        edt_evento_lugar.setText("");
        edt_evento_id.setText("");
        edt_evento_hora_fin.setText("");
        edt_evento_hora_fin.setText("");
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}