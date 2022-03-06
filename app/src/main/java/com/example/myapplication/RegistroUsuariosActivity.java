package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistroUsuariosActivity extends AppCompatActivity {

    Spinner lista;
    Button registrar;
    TextInputEditText nombres, identificacion, dia, mes, año, direccion, nombreContacto, telefonoContacto, parentesco, ocupacion, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);

        nombres=findViewById(R.id.txt_nombre);
        identificacion=findViewById(R.id.txt_numero_identificacion);
        dia=findViewById(R.id.txt_dia);
        mes=findViewById(R.id.txt_mes);
        año=findViewById(R.id.txt_año);
        direccion=findViewById(R.id.txt_direccion);
        nombreContacto=findViewById(R.id.txt_nombre_emergencia);
        telefonoContacto=findViewById(R.id.txt_telefono_emergencia);
        parentesco=findViewById(R.id.txt_parentesco);
        ocupacion=findViewById(R.id.txt_ocupacion);
        email=findViewById(R.id.txt_email);
        registrar=findViewById(R.id.btn_registro);

        lista=findViewById(R.id.lista_genero);
        String[] genero={"Masculino", "Femenino", "Otro"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, genero);
        lista.setAdapter(adapter);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarse();
            }
        });
    }

    private void registrarse() {
        if(
                TextUtils.isEmpty(nombres.getText().toString().trim()) ||
                TextUtils.isEmpty(identificacion.getText().toString().trim()) ||
                TextUtils.isEmpty(dia.getText().toString().trim()) ||
                TextUtils.isEmpty(mes.getText().toString().trim()) ||
                TextUtils.isEmpty(año.getText().toString().trim()) ||
                TextUtils.isEmpty(direccion.getText().toString().trim()) ||
                TextUtils.isEmpty(nombreContacto.getText().toString().trim()) ||
                TextUtils.isEmpty(telefonoContacto.getText().toString().trim()) ||
                TextUtils.isEmpty(parentesco.getText().toString().trim()) ||
                TextUtils.isEmpty(ocupacion.getText().toString().trim()) ||
                TextUtils.isEmpty(email.getText().toString().trim())
        ){
            Toast.makeText(getApplicationContext(), "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
            nombres.setError("Campo nombres no puede estar vacio");
            identificacion.setError("Campo identificacion no puede estar vacio");
            dia.setError("Campo dia no puede estar vacio");
            mes.setError("Campo mes no puede estar vacio");
            año.setError("Campo año no puede estar vacio");
            direccion.setError("Campo direccion no puede estar vacio");
            nombreContacto.setError("Campo nombre de contacto no puede estar vacio");
            telefonoContacto.setError("Campo telefono de contacto no puede estar vacio");
            parentesco.setError("Campo parentesco no puede estar vacio");
            ocupacion.setError("Campo ocupacion no puede estar vacio");
            email.setError("Campo email no puede estar vacio");
        }else if(!validarEmail(email.getText().toString())){
            email.setError("Ingrese un correo valido");
            Toast.makeText(getApplicationContext(), "Ingrese un correo valido", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(RegistroUsuariosActivity.this, HomeActivity.class);
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
}