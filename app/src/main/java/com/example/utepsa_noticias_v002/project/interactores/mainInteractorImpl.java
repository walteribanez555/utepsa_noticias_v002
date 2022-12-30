package com.example.utepsa_noticias_v002.project.interactores;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.utepsa_noticias_v002.project.Adapters.VPAdapter_Main;
import com.example.utepsa_noticias_v002.project.Elements.F_data;
import com.example.utepsa_noticias_v002.project.interfaces.main_Interactor;
import com.example.utepsa_noticias_v002.project.interfaces.onMainFinishListener;
import com.example.utepsa_noticias_v002.project.vista.FragmentChild_MainOption;
import com.example.utepsa_noticias_v002.project.vista.FragmentChild_MainOption_Publicar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class mainInteractorImpl implements main_Interactor {
    @Override
    public void obtMenu( Context context, onMainFinishListener listener) {

        String path = "http://utepsa-np.freeoda.com/Db_Connect/obt_catU.php";



        ArrayList<String> Categorias = new ArrayList<>();
        ArrayList<String> id_Cat = new ArrayList<>();


        StringRequest stringRequest = new StringRequest(Request.Method.GET, path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {



                    JSONArray array = new JSONArray(response);



                    for (int i = 0; i < array.length(); i++) {
                        JSONObject cat_json = array.getJSONObject(i);


                        id_Cat.add(cat_json.getString("id"));
                        Categorias.add(cat_json.getString("nombre_cat"));



                    }

                    if(Categorias.size()>0){
                       F_data f_data  = cargar_Listas(Categorias,id_Cat,context);
                         listener.exitoOperacion(f_data);
                    }
                    else{
                        listener.Error_alcargar();
                    }




                } catch (JSONException e) {

                    Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.Error_alcargar();
            }

        });
        Volley.newRequestQueue(context).add(stringRequest);








        return;
    }

     F_data cargar_Listas(ArrayList<String> categorias,ArrayList<String> id_Cat,Context context){
        F_data f_data = new F_data();

        for(int i = 0;i<=categorias.size()-1;i++){

            f_data.Add_Data(cargar_Fragmento(categorias.get(i),id_Cat.get(i),context),categorias.get(i));


        }


        return  f_data;
     }

     Fragment cargar_Fragmento(String Dato,String Id,Context context){
            if(Dato.equals("Publicar")){
                FragmentChild_MainOption_Publicar nuevo1 = new FragmentChild_MainOption_Publicar();
                return  nuevo1;
            }else{

                ArrayList<String> Datos = new ArrayList<>();


                Datos.add(Id);
                Datos.add(Dato);


                Bundle bundle = new Bundle();


                bundle.putStringArrayList("Datos",Datos );



                FragmentChild_MainOption nuevo = new FragmentChild_MainOption();
                nuevo.setArguments(bundle);
                return nuevo;

            }



     }



}


