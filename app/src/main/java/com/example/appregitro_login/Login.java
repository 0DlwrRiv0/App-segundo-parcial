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

public abstract class Login extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private Button buttonF, buttonL,  buttonR;
    private EditText user, password;
    public static final String archivo = "info.json";

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
                Intent intentAc = new Intent(Login.this,OlvideContra.class);
                startActivity(intentAc);
            }
        });
        button = findViewById(R.id.buttonId);
        button.setOnClickListener(this);
    }
    @Override
    public void onClick(View v)
    {
        Intent intent = new Intent( getBaseContext() , Activity2.class );
        MyInfo testJson = new MyInfo();
        testJson.setNumTel( (int)(Math.random()*100));
        testJson.setContraseña( String.format("Contraseña %d" , (int)(Math.random()*10)));
        testJson.setUser(String.format("Nombre %d" , (int)(Math.random()*7777)));
        testJson.setEmail(String.format("Email %d" , (int)(Math.random()*7777)));
        testJson.setFecha((int)(Math.random()*10));
        intent.putExtra( "hola" , String.format("Hola mundo %d" , (int)(Math.random()*1000) ) );
        intent.putExtra( "testJson" , testJson );
        startActivity( intent );
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

    private boolean writeFile(String text)
    {
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

}
