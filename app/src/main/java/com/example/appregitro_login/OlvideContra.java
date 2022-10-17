package com.example.appregitro_login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class OlvideContra extends AppCompatActivity {

    EditText recupera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olvide_contra);
        recupera = (EditText) findViewById(R.id.recuperarContra);
    }

    public void Forgot(View view){
        String emailRecupera = recupera.getText().toString();

        if (emailRecupera.length() == 0){
            Toast.makeText(this, "Ingresa el email con el que te registraste", Toast.LENGTH_LONG).show();
        }

        if (emailRecupera.length() !=0 ){
            Toast.makeText(this, "Te hemos enviado un correo", Toast.LENGTH_LONG).show();
        }
    }
}