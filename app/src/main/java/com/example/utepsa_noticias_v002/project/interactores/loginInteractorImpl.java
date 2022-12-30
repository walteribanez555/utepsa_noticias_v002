package com.example.utepsa_noticias_v002.project.interactores;

import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.utepsa_noticias_v002.project.interfaces.loginInteractor;
import com.example.utepsa_noticias_v002.project.interfaces.onLoginFinishListener;

import java.util.HashMap;
import java.util.Map;

public class loginInteractorImpl implements loginInteractor {
    @Override
    public void validarUser(String user, String pass, Context context,final onLoginFinishListener listener) {
        if(!user.isEmpty() && !pass.isEmpty()){
            realizarconsulta(user,pass,listener, context);

        }else{
            if(user.isEmpty()){
                listener.userNameError();
            }
            if (pass.isEmpty()){
                listener.passwordError();
            }
        }
        return;
    }

    void realizarconsulta(String user,String pass,onLoginFinishListener listener,Context context){
        String Url = "http://utepsa-np.freeoda.com/Db_Connect/validar_usuario.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()){
                    listener.exitoOperacion(user);
                }else{
                    Toast.makeText(context, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("email",user);
                parametros.put("pass",pass);

                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);



    }
}


