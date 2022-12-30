package com.example.utepsa_noticias_v002.project.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.utepsa_noticias_v002.R;
import com.example.utepsa_noticias_v002.project.interfaces.loginPresenter;
import com.example.utepsa_noticias_v002.project.interfaces.loginView;
import com.example.utepsa_noticias_v002.project.presentador.loginPresenterImpl;

public class Loggin extends AppCompatActivity implements loginView {
    Button btn_Login;
    EditText txt_Email,txt_Password;
    ProgressBar pbLogin;



    private loginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);


        presenter = new loginPresenterImpl(this);


        btn_Login = findViewById(R.id.btn_loggin);
        txt_Email = findViewById(R.id.txt_emaillogin);
        txt_Password = findViewById(R.id.txt_passwordlogin);
        pbLogin= findViewById(R.id.progressBar_login);

        pbLogin.setVisibility(View.GONE);


        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.validarUsuario(txt_Email.getText().toString(),txt_Password.getText().toString(),getApplicationContext());
            }
        });



    }

    @Override
    public void showProgress() {
        pbLogin.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        pbLogin.setVisibility(View.GONE);
    }

    @Override
    public void setErrorUser() {

        Toast.makeText(this, "Usuario necesario", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void setErrorPass() {
        Toast.makeText(this, "Contraseña necesaria", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigatetoMain(String User) {


        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        intent.putExtra("Email",User);
        startActivity(intent);
    }
}