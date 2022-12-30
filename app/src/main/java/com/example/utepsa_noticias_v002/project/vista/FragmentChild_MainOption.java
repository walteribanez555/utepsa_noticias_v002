package com.example.utepsa_noticias_v002.project.vista;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.utepsa_noticias_v002.R;
import com.example.utepsa_noticias_v002.project.Adapters.Noticia;
import com.example.utepsa_noticias_v002.project.Adapters.RVAdapter_Noticia;
import com.example.utepsa_noticias_v002.project.interfaces.catPresenter;
import com.example.utepsa_noticias_v002.project.interfaces.catView;
import com.example.utepsa_noticias_v002.project.presentador.catPresenterImpl;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentChild_MainOption#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentChild_MainOption extends Fragment implements catView {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private catPresenter presenter;
    ImageView imageView;
    TextView textView;
    RecyclerView rvNoticia;

    public FragmentChild_MainOption() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentChild_MainOption.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentChild_MainOption newInstance(String param1, String param2) {
        FragmentChild_MainOption fragment = new FragmentChild_MainOption();
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




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view  =inflater.inflate(R.layout.fragment_child__main_option, container, false);


        imageView = view.findViewById(R.id.img_noinfo);
        textView = view.findViewById(R.id.txt_noinfo);
        rvNoticia = view.findViewById(R.id.RV_noticia);




        return view;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();






        ArrayList<String> Datos  = bundle.getStringArrayList("Datos");


        presenter = new catPresenterImpl(this);


        presenter.obtenerNoticias(Datos.get(0),getActivity().getApplicationContext());




    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError() {

        imageView.setVisibility(View.VISIBLE);

        textView.setVisibility(View.VISIBLE);
        hideProgress();

    }

    @Override
    public void enviarDatos(ArrayList<Noticia> noticias) {

        rvNoticia.setLayoutManager(new LinearLayoutManager(getContext()));

        RVAdapter_Noticia adapter_noticia =new RVAdapter_Noticia(noticias);


        rvNoticia.setAdapter(adapter_noticia);

    }
}