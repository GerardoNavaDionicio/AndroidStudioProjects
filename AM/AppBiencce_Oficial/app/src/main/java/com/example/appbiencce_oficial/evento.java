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

import java.util.Calendar;
import java.util.Date;

public class evento extends AppCompatActivity implements View.OnClickListener {
    EditText edt_evento_id, edt_evento_lugar,edt_evento_hora_inicio,edt_evento_hora_fin,edt_evento_fecha;
    Button pb_actualizar_evento,pb_consultar_evento,pb_eliminar_evento,pb_registrar_evento,pb_evento_hora_inicio,pb_evento_hora_fin,pb_evento_fecha;
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
                    edt_evento_fecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);
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
                    edt_evento_hora_inicio.setText(hourOfDay+"/"+minute);
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
                    edt_evento_hora_fin.setText(hourOfDay+"/"+minute);
                }
            },hora,minutos,false);
            timePickerDialog.show();
        }
    }
}