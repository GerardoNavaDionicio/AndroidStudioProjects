package com.example.appbiencce_oficial;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class equipo extends AppCompatActivity {
    RadioButton rb_equipo_si,rb_equipo_no;
    EditText edt_equipo_id, edt_equipo_nombre, edt_equipo_marca,edt_equipo_descripcion,edt_equipo_cantidad,link;
    ImageView imageView2;
    RequestQueue requestQueue;

    Button pb_actualizar_equipo,pb_consultar_equipo,pb_eliminar_equipo,pb_registrar_equipo,pb_cargar_imagen_equipo;

    Bitmap bitmap;
    int PICK_IMAGE_REQUEST=1;
    String KEY_IMAGE = "foto";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipo);

        imageView2 = (ImageView)findViewById(R.id.imageView2);
        rb_equipo_no = (RadioButton) findViewById(R.id.rb_equipo_si);
        rb_equipo_si = (RadioButton) findViewById(R.id.rb_equipo_no);

        edt_equipo_id          = (EditText)findViewById(R.id.edt_equipo_id);
        edt_equipo_nombre      = (EditText)findViewById(R.id.edt_equipo_nombre);
        edt_equipo_marca       = (EditText)findViewById(R.id.edt_equipo_marca);
        edt_equipo_descripcion = (EditText)findViewById(R.id.edt_equipo_descripcion);
        edt_equipo_cantidad    = (EditText)findViewById(R.id.edt_equipo_cantidad);

        pb_registrar_equipo  = (Button)findViewById(R.id.pb_registrar_equipo);
        pb_consultar_equipo  = (Button)findViewById(R.id.pb_consultar_equipo);
        pb_actualizar_equipo = (Button)findViewById(R.id.pb_actualizar_equipo);
        pb_eliminar_equipo   = (Button)findViewById(R.id.pb_eliminar_equipo);
        pb_cargar_imagen_equipo = (Button)findViewById(R.id.pb_cargar_imagen_equipo);

        link=(EditText)findViewById(R.id.edittext);

        pb_consultar_equipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscar("http://192.168.7.5/cursomovil/selectEqui.php?id_equipo="+edt_equipo_id.getText()+"");
            }
        });
        pb_registrar_equipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar( "http://192.168.7.5/cursomovil/insertarEqui2.php");
            }
        });
        pb_actualizar_equipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actu("http://192.168.7.5/cursomovil/actualizarEqui.php");
            }
        });
        pb_eliminar_equipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminar("http://192.168.7.5/cursomovil/eliminarEqui.php");
            }
        });
        pb_cargar_imagen_equipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFileChooser();
            }
        });
    }

    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Seleciona imagen"), PICK_IMAGE_REQUEST);
    }
    public String getStringImagen(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {
                //Cómo obtener el mapa de bits de la Galería
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                //Configuración del mapa de bits en ImageView
                imageView2.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
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
                        edt_equipo_nombre.setText(jsonObject.getString("nombre"));
                        edt_equipo_marca.setText(jsonObject.getString("marca"));
                        edt_equipo_descripcion.setText(jsonObject.getString("descripcion"));
                        edt_equipo_cantidad.setText(jsonObject.getString("cantidad"));
                        link.setText(jsonObject.getString("foto"));
                        String url= link.getText().toString();
                        Picasso.get()
                                .load(""+url)
                                .error(R.mipmap.ic_launcher_round)
                                .into(imageView2);
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
                parametros.put("id_equipo", edt_equipo_id.getText().toString());
                edt_equipo_cantidad.setText("");
                edt_equipo_nombre.setText("");
                edt_equipo_marca.setText("");
                edt_equipo_descripcion.setText("");
                rb_equipo_no.setChecked(false);
                rb_equipo_si.setChecked(false);
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
                String equi="";
                String foto = getStringImagen(bitmap);
                if(rb_equipo_no.isChecked()){
                    equi="1";
                }
                else if(rb_equipo_si.isChecked()){
                    equi="0";
                }
                Map<String, String> parametros  = new HashMap<String, String>();
                parametros.put("id_equipo", edt_equipo_id.getText().toString());
                parametros.put("nombre", edt_equipo_nombre.getText().toString());
                parametros.put("marca", edt_equipo_marca.getText().toString());
                parametros.put("descripcion", edt_equipo_descripcion.getText().toString());
                parametros.put("cantidad",edt_equipo_cantidad.getText().toString());
                parametros.put("disponibilidad",equi);
                parametros.put(KEY_IMAGE, foto);
                edt_equipo_cantidad.setText("");
                edt_equipo_nombre.setText("");
                edt_equipo_marca.setText("");
                edt_equipo_descripcion.setText("");
                rb_equipo_no.setChecked(false);
                rb_equipo_si.setChecked(false);
                imageView2.setImageResource(R.drawable.user);
                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void registrar(String URL){
        final ProgressDialog loading = ProgressDialog.show(this, "Subiendo...", "Espere por favor");
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                loading.dismiss();
                Toast.makeText(getApplicationContext(), "Registro creado exitosamente", Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loading.dismiss();
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                String equi="";
                String foto = getStringImagen(bitmap);
                if(rb_equipo_no.isChecked()){
                    equi="1";

                }
                else if(rb_equipo_si.isChecked()){
                    equi="0";

                }
                Map<String, String> parametros  = new HashMap<String, String>();
                parametros.put("nombre", edt_equipo_nombre.getText().toString());
                parametros.put("marca", edt_equipo_marca.getText().toString());
                parametros.put("descripcion", edt_equipo_descripcion.getText().toString());
                parametros.put("cantidad",edt_equipo_cantidad.getText().toString());
                parametros.put("disponibilidad",equi);
                parametros.put(KEY_IMAGE, foto);
                edt_equipo_cantidad.setText("");
                edt_equipo_nombre.setText("");
                edt_equipo_marca.setText("");
                edt_equipo_descripcion.setText("");
                rb_equipo_no.setChecked(false);
                rb_equipo_si.setChecked(false);
                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


}