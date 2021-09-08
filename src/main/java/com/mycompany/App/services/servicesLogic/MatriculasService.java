package com.mycompany.App.services.servicesLogic;

import java.util.ArrayList;
import com.mycompany.Access.MatriculasControl;
import com.mycompany.Model.MatriculasModel;

public class MatriculasService {
    private static MatriculasService servicio;
    private MatriculasControl cMatricula;
    private ArrayList<MatriculasModel> matriculas;

    public MatriculasService(){
        cMatricula = new MatriculasControl();
        matriculas = cMatricula.getMatriculas();
    }

    public static MatriculasService getService(){
        if(servicio == null)
            servicio = new MatriculasService();
        return servicio;
    }

    public MatriculasModel devolverMatricula(int posicion){
        try{
            return matriculas.get(posicion);
        }
        catch(Exception e){
            return null;
        }
    }

    public void agregarMatricula(MatriculasModel matricula){
        this.matriculas.add(matricula);
    }

    public int devolverCantidadMatriculas(){
        return matriculas.size();
    }
}
