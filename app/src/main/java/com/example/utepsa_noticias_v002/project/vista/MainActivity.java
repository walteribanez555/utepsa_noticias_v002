package com.example.utepsa_noticias_v002.project.vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.utepsa_noticias_v002.R;
import com.example.utepsa_noticias_v002.project.Adapters.VPAdapter_Main;
import com.example.utepsa_noticias_v002.project.Elements.F_data;
import com.example.utepsa_noticias_v002.project.interfaces.mainPresenter;
import com.example.utepsa_noticias_v002.project.interfaces.mainView;
import com.example.utepsa_noticias_v002.project.presentador.mainPresenterImpl;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements mainView {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private VPAdapter_Main vpAdapter_main;


    private mainPresenter presenter;
    private ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_main);
        viewPager = findViewById(R.id.viewPageMain);
        progressBar = findViewById(R.id.pb_main);
        progressBar.setVisibility(View.GONE);


        presenter  = new mainPresenterImpl(this);

        vpAdapter_main = new VPAdapter_Main(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        presenter.fetchData(this);





    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void error_alCargar() {
        Toast.makeText(this, "Error al cargar datos", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void Realizado(F_data f_data) {
        //Toast.makeText(this, f_data.getTitulos().toString(), Toast.LENGTH_SHORT).show();

        vpAdapter_main.add_fragments_titles(f_data);
        viewPager.setAdapter(vpAdapter_main);
        tabLayout.setupWithViewPager(viewPager);

    }


}