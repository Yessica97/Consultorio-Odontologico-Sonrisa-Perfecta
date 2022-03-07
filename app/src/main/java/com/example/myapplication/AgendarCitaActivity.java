package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class AgendarCitaActivity extends AppCompatActivity {

    Button agendar;
    TextInputEditText nombres, identificacion, dia, mes, año, telefono;
    EditText procedimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_cita);

        nombres=findViewById(R.id.txt_nombre);
        identificacion=findViewById(R.id.txt_numero_identificacion);
        dia=findViewById(R.id.txt_dia);
        mes=findViewById(R.id.txt_mes);
        año=findViewById(R.id.txt_año);
        telefono=findViewById(R.id.txt_telefono_emergencia);
        procedimiento=findViewById(R.id.edit_text);
        agendar=findViewById(R.id.btn_registro);

        agendar.setOnClickListener(new View.OnClickListener() {
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
                        TextUtils.isEmpty(telefono.getText().toString().trim()) ||
                        TextUtils.isEmpty(procedimiento.getText().toString().trim())
        ){
            Toast.makeText(getApplicationContext(), "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
            nombres.setError("Campo nombres no puede estar vacio");
            identificacion.setError("Campo identificacion no puede estar vacio");
            dia.setError("Campo dia no puede estar vacio");
            mes.setError("Campo mes no puede estar vacio");
            año.setError("Campo año no puede estar vacio");
            telefono.setError("Campo telefono no puede estar vacio");
            procedimiento.setError("Campo procedimiento no puede estar vacio");
        } else{
            Toast.makeText(getApplicationContext(), "Cita Agendada", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(AgendarCitaActivity.this, HomeActivity.class);
            startActivity(intent);
        }
    }
}