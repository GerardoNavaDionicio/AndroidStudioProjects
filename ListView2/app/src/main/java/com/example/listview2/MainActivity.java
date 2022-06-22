package com.example.listview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lt1 = (ListView) findViewById(R.id.lista);
        List<String> nombres;
        nombres=new ArrayList<>();
        nombres.add("Genady");
        nombres.add("José");
        nombres.add("Paola");

        ArrayAdapter<String>adaptador=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,nombres);
        lt1.setAdapter(adaptador);

        lt1.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                int duration=1;

                Toast.makeText(MainActivity.this, nombres.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}