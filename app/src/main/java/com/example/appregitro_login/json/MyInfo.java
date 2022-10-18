package com.example.appregitro_login.json;

import java.io.Serializable;

public class MyInfo implements Serializable {
    private String user;
    private String email;
    private String password;
    private String phone;
    private String fecha;
    private String edad;
    private String sexo;

    public String getUser(){return user;}
    public void setUser(String user){this.user = user;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}

    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}

    public String getPhone(){return phone;}
    public void setPhone(String phone){this.phone = phone;}

    public String getFecha(){return fecha;}
    public void setFecha(String fecha){this.fecha = fecha;}

    public String getEdad(){return edad;}
    public void setEdad(String edad){this.edad = edad;}

    public String getSexo(){return sexo;}
    public void setSexo(String sexo){this.sexo = sexo;}

}


