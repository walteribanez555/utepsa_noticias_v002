package com.example.utepsa_noticias_v002.project.vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.utepsa_noticias_v002.R;
import com.example.utepsa_noticias_v002.project.Adapters.VPAdapter_Main;

import java.util.ArrayList;

public class Main_Noticia extends AppCompatActivity {


    ViewPager viewPager;
    VPAdapter_Main vpAdapter_main;

    ImageButton imageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_noticia);



        imageButton = findViewById(R.id.imageButton);

        viewPager = findViewById(R.id.vp_noticia);

        vpAdapter_main = new VPAdapter_Main(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),MainActivity.class);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });





        ArrayList<String> noticias = getIntent().getExtras().getStringArrayList("datos_noticia");


        Bundle bundle1 = new Bundle();
        bundle1.putStringArrayList("datos_noticia",noticias);
        Noticia_Portada fragmentChild = new Noticia_Portada();


        fragmentChild.setArguments(bundle1);






        vpAdapter_main.addfragment(fragmentChild,"Portada");




        viewPager.setAdapter(vpAdapter_main);




    }
}