package com.mycompany.Model;

public class MatriculasModel {
    private int idMatriculas;
    private String idEstudiante;
    private int idTutoria;
    
    /*public MatriculasModel(int idMatriculas, String idEstudiante, int idTutoria){
        this.idMatriculas = idMatriculas;
        this.idEstudiante = idEstudiante;
        this.idTutoria = idTutoria;
    }*/

    public int getIdMatriculas(){
        return idMatriculas;
    }

    public void setIdMatriculas(int idMatriculas){
        this.idMatriculas = idMatriculas;
    }

    public String getIdEstudiante(){
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante){
        this.idEstudiante = idEstudiante;
    }

    public int getIdTutoria(){
        return idTutoria;
    }

    public void setIdTutoria(int idTutoria){
        this.idTutoria = idTutoria;
    }
}
