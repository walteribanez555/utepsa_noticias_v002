package com.example.utepsa_noticias_v002.project.Adapters;

import com.google.gson.annotations.SerializedName;

public class Noticia {




    @SerializedName("Titulo") String titulo;
    @SerializedName("Descripcion") String descripcion;
    @SerializedName("Fecha_publicacion") String fecha_public;
    @SerializedName("Categoria") String categoria;
    @SerializedName("dir_imagen") String dir_imagen;


    public Noticia(String titulo, String descripcion, String fecha_public, String categoria, String dir_imagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha_public = fecha_public;
        this.categoria = categoria;
        this.dir_imagen = dir_imagen;
    }


    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFecha_public() {
        return fecha_public;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDir_imagen() {
        return dir_imagen;
    }




}
