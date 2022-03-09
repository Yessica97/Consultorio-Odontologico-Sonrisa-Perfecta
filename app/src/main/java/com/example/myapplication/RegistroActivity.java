package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistroActivity extends AppCompatActivity {

    TextInputEditText email, nombres, apellido;
    EditText contraseña;
    Button registrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        contraseña=findViewById(R.id.txt_contraseña);
        registrarse=findViewById(R.id.btn_registro);
        email=findViewById(R.id.txt_email);
        nombres=findViewById(R.id.txt_nombre);
        apellido=findViewById(R.id.txt_apellido);
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registro();
            }
        });
    }

    private void registro() {
        if(
            TextUtils.isEmpty(contraseña.getText().toString().trim()) ||
            TextUtils.isEmpty(email.getText().toString().trim()) ||
            TextUtils.isEmpty(nombres.getText().toString().trim()) ||
            TextUtils.isEmpty(apellido.getText().toString().trim())
           ){
            contraseña.setError("Campo contraseña no puede estar vacio");
            email.setError("Campo email no puede estar vacio");
            nombres.setError("Campo nombres no puede estar vacio");
            apellido.setError("Campo apellidos no puede estar vacio");
        }else if(!validarEmail(email.getText().toString())){
            email.setError("Ingrese un correo valido");
        }else{
            guardarPreferencias();
            Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(RegistroActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

    private boolean validarEmail(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        pattern=Pattern.compile(EMAIL_PATTERN);
        matcher=pattern.matcher(email);
        return matcher.matches();
    }

    private void guardarPreferencias(){
        SharedPreferences preferences=getSharedPreferences("Usuarios", Context.MODE_PRIVATE);
        String campoContraseña=contraseña.getText().toString();
        String campoEmail=email.getText().toString();
        String campoNombres=nombres.getText().toString();
        String campoApellidos=apellido.getText().toString();
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("contraseña", campoContraseña);
        editor.putString("email", campoEmail);
        editor.putString("nombres", campoNombres);
        editor.putString("apellidos", campoApellidos);
        editor.commit();
    }
}