package com.example.reddy.desarrollo20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class SegundaActivity extends AppCompatActivity {

    TextView edad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        edad = (TextView) findViewById(R.id.edad);
        Bundle bundle = getIntent().getExtras();

        String message = bundle.getString("año", "")+"/"+bundle.getString("mes", "")+"/"+bundle.getString("dia", "");
        edad.setText(message);

        //edad.setText(bundle.getString("edadMeses", ""));
    }
}