package com.example.utepsa_noticias_v002.project.vista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.utepsa_noticias_v002.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Noticia_Portada#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Noticia_Portada extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Noticia_Portada() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Noticia_Portada.
     */
    // TODO: Rename and change types and number of parameters
    public static Noticia_Portada newInstance(String param1, String param2) {
        Noticia_Portada fragment = new Noticia_Portada();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    ArrayList<String> Datos = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_noticia__portada, container, false);

        Bundle bundle = getArguments();
        Datos = bundle.getStringArrayList("datos_noticia");
        getIDs(view);


        return  view;




    }

    TextView txt_titulo, txt_descripcion;
    ImageView img_Portada;
    CollapsingToolbarLayout collapsingToolbarLayout;


    void getIDs(View view){
        txt_titulo = view.findViewById(R.id.txt_title_notice);
        txt_descripcion = view.findViewById(R.id.txt_descripcionfragment);
        collapsingToolbarLayout = view.findViewById(R.id.collapsing_toolbar);
        img_Portada = view.findViewById(R.id.img_noticia);


        txt_titulo.setText(Datos.get(0));
        collapsingToolbarLayout.setTitle(Datos.get(0));
        txt_descripcion.setText(Datos.get(1));


        Glide.with(img_Portada).load(Datos.get(2)).into(img_Portada);


    }


}