package com.example.utepsa_noticias_v002.project.interfaces;

import com.example.utepsa_noticias_v002.project.Elements.F_data;

public interface mainView {


    void showProgress();
    void hideProgress();

    void error_alCargar();

    void Realizado(F_data f_data);
}
