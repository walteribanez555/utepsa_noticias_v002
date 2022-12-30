package com.example.utepsa_noticias_v002.project.presentador;

import android.content.Context;

import com.example.utepsa_noticias_v002.project.Adapters.Noticia;
import com.example.utepsa_noticias_v002.project.interactores.catInteractorImpl;
import com.example.utepsa_noticias_v002.project.interfaces.catInteractor;
import com.example.utepsa_noticias_v002.project.interfaces.catPresenter;
import com.example.utepsa_noticias_v002.project.interfaces.catView;
import com.example.utepsa_noticias_v002.project.interfaces.onCatFinishListener;

import java.util.ArrayList;

public class catPresenterImpl implements catPresenter, onCatFinishListener {

    private catView view;
    private catInteractor interactor;

    public catPresenterImpl(catView view) {
        this.view = view;
        interactor = new catInteractorImpl();
    }


    @Override
    public void obtenerNoticias(String cat, Context context) {
        interactor.cargarDatos(cat,context,this);


    }

    @Override
    public void realizado(ArrayList<Noticia> noticias) {


        view.enviarDatos(noticias);
    }

    @Override
    public void errorAlCargar() {

        view.showError();

    }
}
