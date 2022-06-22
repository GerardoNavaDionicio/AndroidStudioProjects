package com.example.list_view_lista_de_contactos;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Adaptador extends BaseAdapter {

    private static LayoutInflater inflater = null;
    Context contexto;
    String[][] datos;
    int [] datosImg;

    public Adaptador(Context contexto,String[][] datos,int[] imagenes)
    {
        this.contexto=contexto;
        this.datos=datos;
        this.datosImg=imagenes;
        inflater=(LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        final View vista = inflater.inflate(R.layout.elemento_lista, null);

        TextView nombre = (TextView) vista.findViewById(R.id.nom1);
        TextView telefono = (TextView) vista.findViewById(R.id.nom1_1);
        TextView correo = (TextView) vista.findViewById(R.id.nom1_2);
        TextView edad = (TextView) vista.findViewById(R.id.nom1_3);

        ImageView imagen = (ImageView) vista.findViewById(R.id.imageView);

        nombre.setText("Nombre:     "+datos[i][0]);
        edad.setText("Edad:     "+datos[i][3]);
        telefono.setText("Telefono:     " + datos[i][1]);
        correo.setText("Correo:     " + datos[i][2]);
        imagen.setImageResource(datosImg[i]);
        

        return vista;
    }

    @Override
    public int getCount() {
        return datosImg.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


}
