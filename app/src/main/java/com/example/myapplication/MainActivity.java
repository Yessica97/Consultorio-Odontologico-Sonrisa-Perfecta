package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Window window;
    TextView registrase;
    EditText txtxUsuario, txtxContraseña;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.window=getWindow();
        window.setStatusBarColor(Color.parseColor("#000000"));
        window.setNavigationBarColor(Color.parseColor("#00BCD4"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00BCD4")));
        registrase=findViewById(R.id.txt_registrarse);
        registrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });
    }

    public void interaccionLogin(View view) {
        txtxUsuario=findViewById(R.id.usr);
        txtxContraseña=findViewById(R.id.pass);

        SharedPreferences preferences=getSharedPreferences("Usuarios", Context.MODE_PRIVATE);
        String usuario=preferences.getString("usuario", "yessica.carrillo@udea.edu.co");
        String contraseña=preferences.getString("contraseña", "yemacare97");

        String campoUsuario=txtxUsuario.getText().toString();
        String campoContraseña=txtxContraseña.getText().toString();
        if(usuario.equals(campoUsuario) && contraseña.equals(campoContraseña)){
            Intent intent= new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        }else if(!(campoUsuario.equals(usuario))){
            Toast.makeText(getApplicationContext(), "Usuario incorrecto", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), " Contraseña incorrecta", Toast.LENGTH_SHORT).show();
        }
    }
}