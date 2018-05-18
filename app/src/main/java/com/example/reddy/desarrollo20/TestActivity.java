package com.example.reddy.desarrollo20;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {

    //TestMotricidadGruesa
    private int index, edadMeses;
    private TextView pregunta;
    private Button siButton, noButton;
    private Button aObservar, aHacerNiño, aRealizar, siguiente;
    private Bundle bund;
    private String[] preguntasMotricidadfina;
    private String[] preguntasAudicionLenguaje;
    private String[] preguntasPersonalSocial;
    private String[] preguntasMotricidadGruesa;
    private boolean t1 = true , t2 = false, t3 = false, t4 = false;

    private int[] resMotricidadGruesa, resMotricidadFina, resAudicionLenguaje, resPersonalSocial;
    private int incremento = 1, indexInicio, contador = 0;
    private boolean parar = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        pregunta = (TextView)findViewById(R.id.pregunta);
        siButton = (Button)findViewById(R.id.siButton);
        noButton = (Button)findViewById(R.id.noButton);

        aObservar = (Button)findViewById(R.id.aObervar);
        aHacerNiño = (Button)findViewById(R.id.aHacerNiño);
        aRealizar = (Button)findViewById(R.id.aRealizar);
        siguiente = (Button)findViewById(R.id.siguiente);

        index = 0;

        bund = getIntent().getExtras();
        edadMeses = Integer.parseInt(bund.getString("meses", "0"));

        resMotricidadGruesa = new int[37];
        resMotricidadFina = new int[37];
        resPersonalSocial = new int[37];
        resAudicionLenguaje = new int[37];

        indexInicio = 0;
        if(edadMeses>0)
        {   if(edadMeses == 0)      indexInicio = 0;
            else if(edadMeses<=3)   indexInicio= 1;
            else if(edadMeses<=6)   indexInicio= 4;
            else if(edadMeses<=9)   indexInicio= 7;
            else if(edadMeses<=12)  indexInicio= 10;
            else if(edadMeses<=18)  indexInicio= 13;
            else if(edadMeses<=24)  indexInicio= 16;
            else if(edadMeses<=36)  indexInicio= 19;
            else if(edadMeses<=48)  indexInicio= 22;
            else if(edadMeses<=60)  indexInicio= 25;
            else if(edadMeses<=72)  indexInicio= 28;
            else if(edadMeses<=84)  indexInicio= 31;
            else if(edadMeses<=96)  indexInicio= 34;
        }

        for(int i = 0; i < indexInicio; i++)
        {
            resMotricidadGruesa[i] = 1;
            resAudicionLenguaje[i] = 1;
            resPersonalSocial[i] = 1;
            resMotricidadFina[i] = 1;
        }

        index = indexInicio;

        Resources resources = getResources();

        preguntasMotricidadGruesa = resources.getStringArray(R.array.itemsMotricidadGruesa);
        preguntasMotricidadfina = resources.getStringArray(R.array.MotricidadFina);
        preguntasAudicionLenguaje = resources.getStringArray(R.array.AudicionLenguaje);
        preguntasPersonalSocial = resources.getStringArray(R.array.PersonalSocial);

        if(t1)  //motricidad gruesa
        {

            index = indexInicio;
            contador = 1;
            pregunta.setText("Pregunta #"+index+"\n"+preguntasMotricidadGruesa[index]);


            //String mandarAobservar = getStringArray

        }else if(t2)    // motricidad fina
        {
            index = indexInicio;

            pregunta.setText("Pregunta #"+index+"\n"+preguntasMotricidadfina[index]);

        }else if(t3)    //audicion y lenguaje
        {
            index = indexInicio;

            pregunta.setText("Pregunta #"+index+"\n"+preguntasAudicionLenguaje[index]);

        }else if(t4)    //personal y social
        {
            index = indexInicio;

            pregunta.setText("Pregunta #"+index+"\n"+preguntasPersonalSocial[index]);

        }




        aObservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionAobservar();
            }
        });

        aHacerNiño.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionAhacerNiño();
            }
        });

        aRealizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionArealizar();
            }
        });

        siButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionSi();
            }
        });

        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionNo();
            }
        });
    }

    public void actionSi()
    {

        darDatoRespuesta(1);
        if(index == indexInicio)
        {
            //inicializar valores
            if(t1)  //motricidad gruesa
            {
                contador = 1;
                if(resMotricidadGruesa[index] == 1) incremento = 1;
                else incremento = -1;

            }else if(t2)    // motricidad fina
            {
                contador = 1;
                if(resMotricidadFina[index] == 1) incremento = 1;
                else incremento = -1;
            }else if(t3)    //audicion y lenguaje
            {
                contador = 1;
                if(resAudicionLenguaje[index] == 1) incremento = 1;
                else incremento = -1;
            }else if(t4)    //personal y social
            {
                contador = 1;
                if(resPersonalSocial[index] == 1) incremento = 1;
                else incremento = -1;
            }

        }else{


            if(contador > 3) {

                if (t1)  //motricidad gruesa
                {
                    if(incremento == 1) parar = condicionDeParadaIncremento(resMotricidadGruesa, index);
                    else if(incremento == -1)   parar = condicionDeParadaDecremento(resMotricidadGruesa, index);

                    if(parar) {
                        index = indexInicio-1;
                        t1 = false;
                        t2 = true;
                    }

                } else if (t2)    // motricidad fina
                {
                    if(incremento == 1) parar = condicionDeParadaIncremento(resMotricidadFina, index);
                    else if(incremento == -1)   parar = condicionDeParadaDecremento(resMotricidadFina, index);

                    if(parar){
                        index = indexInicio-1;
                        t2 = false;
                        t3 = true;
                    }

                } else if (t3)    //audicion y lenguaje
                {
                    if(incremento == 1) parar = condicionDeParadaIncremento(resAudicionLenguaje, index);
                    else if(incremento == -1)   parar = condicionDeParadaDecremento(resAudicionLenguaje, index);
                    if(parar){
                        index = indexInicio-1;
                        t3 = false;
                        t4 = true;
                    }

                } else if (t4)    //personal y social
                {
                    if(incremento == 1) parar = condicionDeParadaIncremento(resPersonalSocial, index);
                    else if(incremento == -1)   parar = condicionDeParadaDecremento(resPersonalSocial, index);
                    if(parar){
                        index = indexInicio-1;
                        t4 = false;
                        resultados();
                        Intent intent = new Intent(TestActivity.this, ResultadosActivity.class);
                        intent.putExtra("puntaje", String.valueOf(resultados()));
                        intent.putExtra("edadMeses", String.valueOf(edadMeses));
                        startActivity(intent);
                    }

                }
            }

        }
        String cont = String.valueOf(contador);
        Log.d("contador", cont);
        Log.d("si o no", "si");
        contador++;
        index += incremento;

        if(t1)  //motricidad gruesa
        {
            pregunta.setText(preguntasMotricidadGruesa[index]);

        }else if(t2)    // motricidad fina
        {
            pregunta.setText(preguntasMotricidadfina[index]);

        }else if(t3)    //audicion y lenguaje
        {
            pregunta.setText(preguntasAudicionLenguaje[index]);
        }else if(t4)    //personal y social
        {
            pregunta.setText(preguntasPersonalSocial[index]);
        }

    }
    public int resultados()
    {
        int resultado = 0;
        for(int i = 0; i <resMotricidadFina.length; i++)
        {

            if(resMotricidadGruesa[i] == 1) resultado++;
            if(resAudicionLenguaje[i] == 1) resultado++;
            if(resPersonalSocial[i] == 1) resultado++;
            if(resMotricidadFina[i] == 1) resultado++;
        }

        return  resultado;
    }

    public void actionNo()
    {
        darDatoRespuesta(0);
        //inicializar valores
        if(index == indexInicio)
        {
            //inicializar valores
            if(t1)  //motricidad gruesa
            {
                contador = 1;
                if(resMotricidadGruesa[index] == 1) incremento = 1;
                else incremento = -1;

            }else if(t2)    // motricidad fina
            {
                contador = 1;
                if(resMotricidadFina[index] == 1) incremento = 1;
                else incremento = -1;
            }else if(t3)    //audicion y lenguaje
            {
                contador = 1;
                if(resAudicionLenguaje[index] == 1) incremento = 1;
                else incremento = -1;
            }else if(t4)    //personal y social
            {
                contador = 1;
                if(resPersonalSocial[index] == 1) incremento = 1;
                else incremento = -1;
            }

        }else{
            if(contador > 3) {

                if (t1)  //motricidad gruesa
                {
                    if(incremento == 1) parar = condicionDeParadaIncremento(resMotricidadGruesa, index);
                    else if(incremento == -1)   parar = condicionDeParadaDecremento(resMotricidadGruesa, index);

                    if(parar) {
                        index = indexInicio-1;
                        t1 = false;
                        t2 = true;
                    }

                } else if (t2)    // motricidad fina
                {
                    if(incremento == 1) parar = condicionDeParadaIncremento(resMotricidadFina, index);
                    else if(incremento == -1)   parar = condicionDeParadaDecremento(resMotricidadFina, index);

                    if(parar){
                        index = indexInicio-1;
                        t2 = false;
                        t3 = true;
                    }

                } else if (t3)    //audicion y lenguaje
                {
                    if(incremento == 1) parar = condicionDeParadaIncremento(resAudicionLenguaje, index);
                    else if(incremento == -1)   parar = condicionDeParadaDecremento(resAudicionLenguaje, index);
                    if(parar){
                        index = indexInicio-1;
                        t3 = false;
                        t4 = true;
                    }

                } else if (t4)    //personal y social
                {
                    if(incremento == 1) parar = condicionDeParadaIncremento(resPersonalSocial, index);
                    else if(incremento == -1)   parar = condicionDeParadaDecremento(resPersonalSocial, index);
                    if(parar){
                        t4 = false;
                        resultados();
                        Intent intent = new Intent(TestActivity.this, ResultadosActivity.class);
                        intent.putExtra("puntaje", String.valueOf(resultados()));
                        intent.putExtra("edadMeses", String.valueOf(edadMeses));
                        startActivity(intent);
                    }

                }
            }

        }
        Log.d("contador", String.valueOf(contador));
        Log.d("si o no", "no");
        contador++;
        index += incremento;

        if(t1)  //motricidad gruesa
        {
            pregunta.setText(preguntasMotricidadGruesa[index]);

        }else if(t2)    // motricidad fina
        {
            pregunta.setText(preguntasMotricidadfina[index]);

        }else if(t3)    //audicion y lenguaje
        {
            pregunta.setText(preguntasAudicionLenguaje[index]);
        }else if(t4)    //personal y social
        {
            pregunta.setText(preguntasPersonalSocial[index]);
        }


    }


    public boolean condicionDeParadaIncremento(int[] v, int max)
    {
        if(((v[max] == 0) && (v[max-1] == 0) && (v[max-2] == 0))||(max == 0)||(max == 36))
        {
            return true;
        }else   return false;
    }

    public boolean condicionDeParadaDecremento(int[]v, int max)
    {
        if(((v[max]==1) && (v[max+1] == 1) && (v[max+2] == 1))||((max == 0)||(max == 36)))
        {
            return true;
        }
        else return false;
    }

    public void darDatoRespuesta(int valor)
    {
        if(t1)  //motricidad gruesa
        {
            resMotricidadGruesa[index] = valor;
        }else if(t2)    // motricidad fina
        {
            resMotricidadFina[index] = valor;
        }else if(t3)    //audicion y lenguaje
        {
            resAudicionLenguaje[index] = valor;
        }else if(t4)    //personal y social
        {
            resPersonalSocial[index] = valor;
        }
    }

    public void actionAobservar()
    {
        Intent intent = new Intent(TestActivity.this, QueVasAobservarActivity.class);
        startActivity(intent);

    }

    public void actionAhacerNiño()
    {
        Intent intent = new Intent(TestActivity.this, QueDebeHacerElNinoActivity.class);

        startActivity(intent);
    }

    public void actionArealizar()
    {
        Intent intent = new Intent(TestActivity.this, ComoDebeRealizarActivity.class);

        startActivity(intent);
    }

}