package com.example.reddy.desarrollo20;

import android.content.res.Resources;
import android.widget.ImageView;

/**
 * Created by reddy on 5/17/18.
 */

public class TestMotricidadGruesa {
    private String preguntas, queDebeHacerElNiño, queVasAobservar;
    private ImageView comoDebeRealizar;

    public TestMotricidadGruesa(String preguntas, String queDebeHacerElNiño, String queVasAobservar, ImageView comoDebeRealizar) {
        this.preguntas = preguntas;
        this.queDebeHacerElNiño = queDebeHacerElNiño;
        this.queVasAobservar = queVasAobservar;
        this.comoDebeRealizar = comoDebeRealizar;
    }

    public TestMotricidadGruesa(String[] preguntas,/*aqui mandar el resto de arreglos*/ int position)
    {
        //preguntas mandara el tipo de arreglo de string de donde obtener la pregunta
        this.preguntas = preguntas[position];
    }

    public String getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(String preguntas) {
        this.preguntas = preguntas;
    }

    public String getQueDebeHacerElNiño() {
        return queDebeHacerElNiño;
    }

    public void setQueDebeHacerElNiño(String queDebeHacerElNiño) {
        this.queDebeHacerElNiño = queDebeHacerElNiño;
    }

    public String getQueVasAobservar() {
        return queVasAobservar;
    }

    public void setQueVasAobservar(String queVasAobservar) {
        this.queVasAobservar = queVasAobservar;
    }

    public ImageView getComoDebeRealizar() {
        return comoDebeRealizar;
    }

    public void setComoDebeRealizar(ImageView comoDebeRealizar) {
        this.comoDebeRealizar = comoDebeRealizar;
    }
}
