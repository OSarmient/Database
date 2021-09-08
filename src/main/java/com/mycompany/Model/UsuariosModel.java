package com.mycompany.Model;

public class UsuariosModel {
    private String correoElectronico;
    private String nombres;
    private String apellidos;
    private int edad;
    private String contraseña;
    private int idRol;
    
    /*public UsuariosModel(String correoElectronico, String nombres, String apellidos, int edad, String contraseña, int idRol){
        this.correoElectronico = correoElectronico;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.contraseña = contraseña;
        this.idRol = idRol;
    }*/

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres){
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol){
        this.idRol = idRol;
    }
}
