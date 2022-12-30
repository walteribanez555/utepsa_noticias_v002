package com.example.utepsa_noticias_v002.project.presentador;

import android.content.Context;

import com.example.utepsa_noticias_v002.project.interactores.loginInteractorImpl;
import com.example.utepsa_noticias_v002.project.interfaces.loginInteractor;
import com.example.utepsa_noticias_v002.project.interfaces.loginPresenter;
import com.example.utepsa_noticias_v002.project.interfaces.loginView;
import com.example.utepsa_noticias_v002.project.interfaces.onLoginFinishListener;


public class loginPresenterImpl implements loginPresenter, onLoginFinishListener {

    private  loginView view;
    private loginInteractor interactor;


    @Override
    public void userNameError() {
        view.hideProgress();
        view.setErrorUser();
    }

    @Override
    public void passwordError() {
        view.hideProgress();
        view.setErrorPass();
    }

    @Override
    public void exitoOperacion(String user) {
        view.hideProgress();
        view.navigatetoMain(user);
    }


    public  loginPresenterImpl(loginView view){
        this.view = view;
        interactor = new loginInteractorImpl();

    }




    @Override
    public void validarUsuario(String User, String Password, Context context) {
        view.showProgress();
        interactor.validarUser(User,Password,context,this);
    }
}
