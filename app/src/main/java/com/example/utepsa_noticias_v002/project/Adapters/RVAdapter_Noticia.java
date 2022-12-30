package com.example.utepsa_noticias_v002.project.Adapters;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.utepsa_noticias_v002.R;
import com.example.utepsa_noticias_v002.project.vista.Main_Noticia;
import com.example.utepsa_noticias_v002.project.vista.Noticia_Portada;

import org.w3c.dom.Text;

import java.nio.BufferUnderflowException;
import java.util.ArrayList;


public class RVAdapter_Noticia extends RecyclerView.Adapter<RVAdapter_Noticia.Holder_noticias>{


    ArrayList<Noticia> noticias;
    private Context context;


    public RVAdapter_Noticia(ArrayList<Noticia> noticias){
        this.noticias = noticias;

    }



    public Holder_noticias onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_noticia,null,false);

        return new Holder_noticias(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Holder_noticias holder, int position) {

    holder.txt_Fecha.setText(noticias.get(position).getFecha_public());
    holder.txt_Descripcion.setText(noticias.get(position).getDescripcion());
    holder.txt_categoria.setText(noticias.get(position).getCategoria());
    holder.txt_Titulo.setText(noticias.get(position).getTitulo());
    Glide.with(holder.imgView).load(noticias.get(position).getDir_imagen()).into(holder.imgView);


    holder.cdviewData.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(view.getContext(), Main_Noticia.class);

            Bundle bundle = new Bundle();

            ArrayList<String> datos_noticia = new ArrayList<>();
            datos_noticia.add(noticias.get(position).getTitulo());
            datos_noticia.add(noticias.get(position).getDescripcion());
            datos_noticia.add(noticias.get(position).getDir_imagen());

           intent.putStringArrayListExtra("datos_noticia",datos_noticia);



            view.getContext().startActivity(intent);
        }
    });



    }



    @Override
    public int getItemCount() {
        return noticias.size();
    }


    public static class Holder_noticias extends  RecyclerView.ViewHolder{
        TextView txt_Titulo,txt_Descripcion,txt_Fecha,txt_categoria;
        ImageView imgView;


        CardView cdviewData;

        public Holder_noticias(@NonNull View itemView){
            super(itemView);

            cdviewData = itemView.findViewById(R.id.cardview_noticiaitem);

            txt_Titulo = itemView.findViewById(R.id.txt_title_cardRV);
            txt_Descripcion = itemView.findViewById(R.id.txt_descripcionRV);
            txt_categoria = itemView.findViewById(R.id.txt_cat_cardRV);
            txt_Fecha = itemView.findViewById(R.id.txt_fechaRV);

            imgView = itemView.findViewById(R.id.img_thumb);

        }

    }


}
