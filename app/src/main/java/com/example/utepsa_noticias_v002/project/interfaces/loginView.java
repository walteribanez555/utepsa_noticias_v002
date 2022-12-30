package com.example.utepsa_noticias_v002.project.interfaces;

public interface loginView {



    void showProgress();
    void hideProgress();

    void setErrorUser();
    void setErrorPass();



    void navigatetoMain(String User);

}
