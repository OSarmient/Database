package com.mycompany.Model;

public class TutoriasModel {
    private int idTutoria;
    private String titulo;
    private String descripcion;
    private int año;
    private String idDocenteEncargado;

    /*public TutoriasModel(int idTutoria, String titulo, String descripcion, int año, String idDocenteEncargado){
        this.idTutoria = idTutoria;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.año = año;
        this.idDocenteEncargado = idDocenteEncargado;
    }*/

    public int getIdTutoria(){
        return idTutoria;
    }

    public void setIdTutoria(){
        this.idTutoria = idTutoria;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getDescipcion(){
        return descripcion;
    }

    public void setDescripcion(String descipcion){
        this.descripcion = descripcion;
    }

    public int getAño(){
        return año;
    }

    public void setAño(int año){
        this.año = año;
    }

    public String getIdDocenteEncargado(){
        return idDocenteEncargado;
    }

    public void setIdDocenteEncargado(String idDocenteEncargado){
        this.idDocenteEncargado = idDocenteEncargado;
    }

}
