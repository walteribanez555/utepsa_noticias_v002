package com.example.utepsa_noticias_v002.project.interfaces;

import com.example.utepsa_noticias_v002.project.Adapters.Noticia;

import java.util.ArrayList;

public interface catView {

    void showProgress();

    void hideProgress();

    void showError();

    void enviarDatos(ArrayList<Noticia> noticias);

}
