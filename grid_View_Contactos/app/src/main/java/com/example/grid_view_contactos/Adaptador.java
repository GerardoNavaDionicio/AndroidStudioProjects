package com.example.grid_view_contactos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adaptador extends BaseAdapter {
    public Context context;
    private int layout;
    private List<String>nombres;
    private List<String>telefonos;
    private int[] imagenes;

    public Adaptador(Context context,int layout, List<String>nombres,List<String>telefonos,int[]imagenes)
    {
        this.context=context;
        this.layout=layout;
        this.nombres=nombres;
        this.telefonos=telefonos;
        this.imagenes=imagenes;
    }
    @Override
    public int getCount() {
        return nombres.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup ) {
        View v;

        LayoutInflater layoutInflater=LayoutInflater.from(context);

        v=layoutInflater.inflate(R.layout.elemento,null);

        String nombreActual=nombres.get(i);
        String telActual=telefonos.get(i);
        int ingActual=imagenes[i];

        TextView txtNombre=v.findViewById(R.id.txtNombre);
        TextView txtTelefono=v.findViewById(R.id.txtTelefono);
        ImageView imgFoto=v.findViewById(R.id.imgFoto);

        txtNombre.setText(nombreActual);
        txtTelefono.setText(telActual);
        imgFoto.setImageResource(ingActual);

        return v;

    }
}
