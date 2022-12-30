package com.example.utepsa_noticias_v002.project.interactores;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.utepsa_noticias_v002.project.Adapters.Noticia;
import com.example.utepsa_noticias_v002.project.Elements.F_data;
import com.example.utepsa_noticias_v002.project.interfaces.catInteractor;
import com.example.utepsa_noticias_v002.project.interfaces.onCatFinishListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
 
public class catInteractorImpl implements catInteractor {


    @Override
    public void cargarDatos(String nombre_cat, Context context, onCatFinishListener listener) {


        String path = "http://utepsa-np.freeoda.com/Db_Connect/obt_Not.php?id="+nombre_cat;

        ArrayList<Noticia> noticias = new ArrayList<>();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {




                    JSONArray array = new JSONArray(response);



                    for (int i = 0; i < array.length(); i++) {
                        JSONObject not_json = array.getJSONObject(i);

                        Noticia noticia = new Noticia(
                                not_json.getString("titulo"),
                                not_json.getString("descripcion"),
                                not_json.getString("created_at"),
                                not_json.getString("nombre_cat"),
                                not_json.getString("url_img")
                        );


                        noticias.add(noticia);






                    }

                    if(noticias.size()>0){


                        listener.realizado(noticias);
                    }
                    else{

                        listener.errorAlCargar();
                    }




                } catch (JSONException e) {


                    listener.errorAlCargar();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show();
                listener.errorAlCargar();
            }

        });
        Volley.newRequestQueue(context).add(stringRequest);








        return;
    }







}
