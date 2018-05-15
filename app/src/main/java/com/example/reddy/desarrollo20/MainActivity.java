package com.example.reddy.desarrollo20;

import android.content.Intent;
import android.os.Build;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar = (CalendarView)findViewById(R.id.calendar);
        siguiente = (Button) findViewById(R.id.siguiente);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                action();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void action(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String selectedDate = sdf.format(new Date(calendar.getDate()));

        Intent intent = new Intent(this, SegundaActivity.class);
        intent.putExtra("edadMeses", mesDesdeNac(selectedDate));
        startActivity(intent);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String mesDesdeNac(String fecha)
    {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(fecha, fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);

        return String.valueOf(periodo.getMonths()+(periodo.getYears()*12));
    }

}