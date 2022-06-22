package com.example.list_view_lista_de_contactos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    String[][] datos = {
            {"Nore", "2214201231", "nore.beatriz@uppuebla.edu.mx", "22"},
            {"Luis", "1234567890", "Luis.Chido@uppuebla.edu.mx", "21"},
            {"Carlos", "1010101010", "Carlos.Eduardo@uppuebla.edu.mx", "23"},
            {"Gerardo", "2221923578", "Gerardo.nava1829@uppuebla.edu.mx", "24"},
            {"Norma", "2221923779", "Norma.Luna@uppuebla.edu.mx", "24"},


    };
    int[] datosImg = {R.drawable.dbs_1, R.drawable.dbs_2, R.drawable.dbs_3, R.drawable.dbs_4, R.drawable.dbs_5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.lvLista);

        lista.setAdapter(new Adaptador(this, datos, datosImg));
    }

}
