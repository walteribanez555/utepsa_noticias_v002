package com.example.utepsa_noticias_v002.project.Elements;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class F_data {
    public ArrayList<Fragment> getFragments() {
        return fragments;
    }

    public ArrayList<String> getTitulos() {
        return titulos;
    }

    ArrayList<Fragment> fragments = new ArrayList<>();
    ArrayList<String> titulos = new ArrayList<>();



    public void Add_Data(Fragment fragment, String titulo){
        fragments.add(fragment);
        titulos.add(titulo);
    }



}
