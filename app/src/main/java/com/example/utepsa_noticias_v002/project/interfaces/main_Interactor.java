package com.example.utepsa_noticias_v002.project.interfaces;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.example.utepsa_noticias_v002.project.Adapters.VPAdapter_Main;
import com.example.utepsa_noticias_v002.project.Elements.F_data;

import java.util.ArrayList;

public interface main_Interactor {

    void obtMenu(Context context, onMainFinishListener listener);
}
