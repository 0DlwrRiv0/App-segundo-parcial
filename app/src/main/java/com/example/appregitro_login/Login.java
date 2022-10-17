package com.example.appregitro_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appregitro_login.json.MyInfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import kotlin.LateinitKt;

public class Login extends AppCompatActivity {
    Button buttonF, buttonL,  buttonR;
    private EditText user, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonF = findViewById(R.id.buttonF);
        user = (EditText) findViewById(R.id.nomUserLogin);
        password = (EditText) findViewById(R.id.passwordL);

        buttonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,OlvideContra.class);
                startActivity(intent);
            }
        });
    }
    public void buttonR (View view){
        Intent buttonR = new Intent(this, Registro.class);
        startActivity(buttonR);
    }

    public void Registrar(View view){
        String nomUser = user.getText().toString();
        String passpass = password.getText().toString();

        if (nomUser.length() == 0){
            Toast.makeText(this, "Ingresa tu nombre de usuario", Toast.LENGTH_LONG).show();
        }
        if (passpass.length()==0){
            Toast.makeText(this, "Ingresa una contraseña", Toast.LENGTH_LONG).show();
        }

        if (nomUser.length() !=0 && passpass.length() != 0 ){
            Toast.makeText(this, "Ingresando", Toast.LENGTH_LONG).show();
        }
    }
}