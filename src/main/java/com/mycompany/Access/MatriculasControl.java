package com.mycompany.Access;

import java.util.*;
import java.io.*;
import com.mycompany.Model.MatriculasModel;

public class MatriculasControl {
    private ArrayList<MatriculasModel> matriculas;
    
    public MatriculasControl(){
        matriculas = new ArrayList<MatriculasModel>();
        cargarDatos();
    }

    public void cargarDatos(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File ("C:/Users/Usuario/Documents/NetBeansProjects/database/src/main/java/com/mycompany/archives/matriculas.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){
                String[] atributos = linea.split(",");
                MatriculasModel matricula = new MatriculasModel();
                matricula.setIdMatriculas(Integer.parseInt(atributos[0]));
                matricula.setIdEstudiante(atributos[1]);
                matricula.setIdTutoria(Integer.parseInt(atributos[2]));
                matriculas.add(matricula);
            }
            fr.close(); 
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<MatriculasModel> getMatriculas(){
        return matriculas;
    }
}
