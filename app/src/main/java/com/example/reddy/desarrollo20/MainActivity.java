package com.example.reddy.desarrollo20;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    CalendarView calendar;
    Button siguiente;
    private int dia, mes, año;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar = (CalendarView)findViewById(R.id.calendar);
        siguiente = (Button) findViewById(R.id.siguiente);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                año = i;
                mes = i1;
                dia = i2;

            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
                intent.putExtra("año", String.valueOf(año));
                intent.putExtra("mes", String.valueOf(mes));
                intent.putExtra("dia", String.valueOf(dia));
                startActivity(intent);
                
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void action(){


        Intent intent = new Intent(this, SegundaActivity.class);
        intent.putExtra("edadMeses", mesDesdeNac(año, mes, dia));
        startActivity(intent);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String mesDesdeNac(int año, int mes, int dia)
    {
        LocalDate fechaNac = LocalDate.of(año, mes, dia);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);

        return String.valueOf(periodo.getMonths()+(periodo.getYears()*12));
    }

}