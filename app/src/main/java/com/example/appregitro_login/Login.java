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

public class Login extends AppCompatActivity {
    public static List<MyInfo> list;
    public static String TAG = "mensaje";
    public static String json = null;
    private EditText nomUserLogin, passwordL;
    public static final String archivo = "info.json";

    private Button buttonL, buttonR, buttonF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonL = findViewById(R.id.buttonL);
        buttonR = findViewById(R.id.buttonR);
        buttonF = findViewById(R.id.buttonF);
        nomUserLogin = findViewById(R.id.nomUserLogin);
        passwordL = findViewById(R.id.passwordL);
        ReadData();

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

    private void ReadData(){
        buttonL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nomUserLogin.getText().length() == 0){
                    Toast.makeText( getApplicationContext() , "Campo vacio, favor de llenar" , Toast.LENGTH_LONG ).show();
                    return;
                }
                if (passwordL.getText().length() == 0){
                    Toast.makeText( getApplicationContext() , "Campo vacio, favor de llenar" , Toast.LENGTH_LONG ).show();
                    return;
                }
                if (writeFile(nomUserLogin.getText().toString())){
                    nomUserLogin.setText("");
                    return;
                }
                if (writeFile(passwordL.getText().toString())){
                    passwordL.setText("");
                }
            }
        });
    }

    private boolean writeFile(String text){
        File file = null;
        FileOutputStream fileOutputStream = null;
        try
        {
            file = getFile();
            fileOutputStream = new FileOutputStream( file );
            fileOutputStream.write( text.getBytes(StandardCharsets.UTF_8) );
            fileOutputStream.close();
            return true;
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    private File getFile( )
    {
        return new File( getDataDir() , archivo );
    }

    private boolean isFileExits( )
    {
        File file = getFile( );
        if( file == null )
        {
            return false;
        }
        return file.isFile() && file.exists();
    }
}