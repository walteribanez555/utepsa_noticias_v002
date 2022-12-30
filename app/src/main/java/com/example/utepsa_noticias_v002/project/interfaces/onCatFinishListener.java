package com.example.utepsa_noticias_v002.project.interfaces;

import com.example.utepsa_noticias_v002.project.Adapters.Noticia;

import java.util.ArrayList;

public interface onCatFinishListener {


    void realizado(ArrayList<Noticia> noticias);

    void errorAlCargar();


}
