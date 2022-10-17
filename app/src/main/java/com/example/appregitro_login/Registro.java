package com.example.appregitro_login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;

public class Registro extends AppCompatActivity {

    private EditText userNameRegistro, email, password, phone, date;
    private RadioButton rb1, rb2;
    private CheckBox checkBox;
    private Button buttonRegistro, toogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }

}