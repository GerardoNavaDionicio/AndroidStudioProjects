package com.example.grid_view_contactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    GridView tabla;
    List<String> nombres;
    List <String> telefonos;
    List <String> descripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabla=findViewById(R.id.tabla);
        nombres=new ArrayList<String>();
        nombres.add("Nore Beatriz");
        nombres.add("Luis");
        nombres.add("Carlos");
        nombres.add("Gerardo");
        nombres.add("Norma");

        telefonos=new ArrayList<String>();
        telefonos.add("1111111111");
        telefonos.add("22222222222");
        telefonos.add("33333333333");
        telefonos.add("444444444444");
        telefonos.add("555555555555");

        descripcion=new ArrayList<String>();
        descripcion.add("Hola, Soy Nore Beatriz Perez Tlacomulco");
        descripcion.add("hola Soy Luis Fernando Fercho");
        descripcion.add("Hola,soy carlos Efduardo Laloca");
        descripcion.add("Hola, soy Gerardo Nava Dionicio");
        descripcion.add("Hola, soy Norma Luna Molanco");


        final int[] imagenes= {
                R.drawable.dbs_1,
                R.drawable.dbs_2,
                R.drawable.dbs_3,
                R.drawable.dbs_4,
                R.drawable.dbs_5
        };

        Adaptador adaptador = new Adaptador(this,R.layout.elemento,nombres,telefonos,imagenes);

        tabla.setAdapter(adaptador);

        tabla.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,Detalle.class);
                intent.putExtra("nombre",nombres.get(i));
                intent.putExtra("telefono",telefonos.get(i));
                intent.putExtra("imagen",imagenes[i]);
                intent.putExtra("description",descripcion.get(i));
                startActivity(intent);

                Toast.makeText(MainActivity.this,"hola soy:  "+ nombres.get(i), Toast.LENGTH_SHORT).show();


            }
        });
    }
}