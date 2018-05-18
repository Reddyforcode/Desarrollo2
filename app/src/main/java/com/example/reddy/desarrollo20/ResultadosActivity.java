package com.example.reddy.desarrollo20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadosActivity extends AppCompatActivity {

    private TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);


        res = (TextView)findViewById(R.id.res);

        Bundle b = getIntent().getExtras();

        res.setText(b.getString("puntaje", "no shego papu"));
    }
}
