package com.example.grid_view_contactos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Detalle extends AppCompatActivity {

    TextView txtNombre,txtTelefono,txtDes;
    ImageView imgFoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        txtNombre=findViewById(R.id.txtNombre);
        txtTelefono=findViewById(R.id.txtTelefono);
        txtDes=findViewById(R.id.txtDes);

        imgFoto=findViewById(R.id.imgFoto);

        Bundle bundle=getIntent().getExtras();

        txtNombre.setText(bundle.getString("nombre"));
        txtTelefono.setText(bundle.getString("telefono"));
        txtDes.setText(bundle.getString("description"));
        imgFoto.setImageResource(bundle.getInt("imagen"));


    }
}