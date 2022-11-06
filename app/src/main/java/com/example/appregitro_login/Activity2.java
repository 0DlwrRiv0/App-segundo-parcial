package com.example.appregitro_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.appregitro_login.json.MyInfo;

public class Activity2 extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String aux = null;
        MyInfo testJson = null;
        Object object = null;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        textView = findViewById(R.id.textViewId);
        Intent intentAc = getIntent();
        if( intentAc != null)
        {
            aux = intentAc.getStringExtra("hola" );
            if( aux != null && aux.length()> 0 )
            {
                textView.setText(aux);
            }
            if( intentAc.getExtras() != null ) {
                object = intentAc.getExtras().get("testJson");
                if (object != null) {
                    if (object instanceof MyInfo) {
                        testJson = (MyInfo) object;
                        textView.setText(testJson.getUser() + "email=" + testJson.getEmail());
                    }
                }
            }
        }
    }
}