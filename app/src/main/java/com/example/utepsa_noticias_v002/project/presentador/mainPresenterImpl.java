package com.example.utepsa_noticias_v002.project.presentador;

import android.content.Context;

import com.example.utepsa_noticias_v002.project.Elements.F_data;
import com.example.utepsa_noticias_v002.project.interactores.mainInteractorImpl;
import com.example.utepsa_noticias_v002.project.interfaces.mainPresenter;
import com.example.utepsa_noticias_v002.project.interfaces.mainView;
import com.example.utepsa_noticias_v002.project.interfaces.main_Interactor;
import com.example.utepsa_noticias_v002.project.interfaces.onMainFinishListener;

public class  mainPresenterImpl implements mainPresenter, onMainFinishListener {
    private com.example.utepsa_noticias_v002.project.interfaces.mainView view;
    private main_Interactor interactor;


    @Override
    public void fetchData(Context context) {
        view.showProgress();
        interactor.obtMenu(context,this);
    }

    public mainPresenterImpl(mainView view){
        this.view  = view;
        interactor = new mainInteractorImpl();
    }

    @Override
    public void Error_alcargar() {
        view.hideProgress();
        view.error_alCargar();
    }

    @Override
    public void exitoOperacion(F_data f_data) {
        view.hideProgress();
        view.Realizado(f_data);
    }
}
