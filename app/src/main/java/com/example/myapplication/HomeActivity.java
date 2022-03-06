package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void pantallaRegistro(View view) {
        Intent intent=new Intent(HomeActivity.this, RegistroUsuariosActivity.class);
        startActivity(intent);
    }

    public void pantallaLista(View view) {
        Intent intent=new Intent(HomeActivity.this, RegistroActivity.class);
        startActivity(intent);
    }

    public void pantallaAgendar(View view) {
        Intent intent=new Intent(HomeActivity.this, RegistroActivity.class);
        startActivity(intent);
    }

    public void pantallaLogin(View view) {
        Intent intent=new Intent(HomeActivity.this, MainActivity.class);
        startActivity(intent);
    }
}