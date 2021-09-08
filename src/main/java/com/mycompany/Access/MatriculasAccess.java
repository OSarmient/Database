package com.mycompany.Access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.logging.Level;
import java.util.logging.Logger;

import com.mycompany.Utils.DatabaseConnection;

public class MatriculasAccess {

    private static Connection conn = null;

    public static void setUsuarios(int idMatriculas, String idEstudiante, int idTutoria){
        String insert = "INSERT INTO matriculas (id_matriculas, id_estudiante, id_tutoria) VALUES(?, ?, ?);";
        try {
            if(conn == null){
                conn = DatabaseConnection.connect();
            }
            PreparedStatement pS = conn.prepareStatement(insert);
            pS.setInt(1, idMatriculas);
            pS.setString(2, idEstudiante);
            pS.setInt(3, idTutoria);
            pS.executeUpdate();
            System.out.println("Matricula guardada");
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MatriculasAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getUsuarios(){
        String query = "SELECT * FROM matriculas;";
        
        try{
            if(conn == null){
                conn = DatabaseConnection.connect();
            }
            PreparedStatement pS = conn.prepareStatement(query);
            ResultSet rS = pS.executeQuery();
            while(rS.next()){
                int idMatriculas = rS.getInt("id_matriculas");
                String idEstudiante = rS.getString("id_estudiante");
                int idTutoria = rS.getInt("id_tutoria");
                
                System.out.println(String.format("La matricula # %s del estudiante %s de la tutoria %s", idMatriculas, idEstudiante, idTutoria));
            }
            conn.close();
        }catch(SQLException ex){
            Logger.getLogger(MatriculasAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updateUsuariosNombres(String idEstudiante, int idMatriculas){
        String update = "UPDATE matriculas SET id_estudiante = ? WHERE id_matriculas = ?;";
        try {
            if(conn == null){
                conn = DatabaseConnection.connect();
            }
            PreparedStatement pS = conn.prepareStatement(update);
            pS.setString(1, idEstudiante);
            pS.setInt(2, idMatriculas);
            pS.executeUpdate();
            System.out.println("Actualizado");
            pS.close();
        } catch (SQLException ex) {
            Logger.getLogger(MatriculasAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteUsuarios(int idMatriculas){
        String delete = "DELETE FROM tutorias WHERE id_matriculas = ?;";
        try {
            if(conn == null){
                conn = DatabaseConnection.connect();
            }
            PreparedStatement pS = conn.prepareStatement(delete);
            pS.setInt(1, idMatriculas);
            pS.executeUpdate();
            System.out.println("Borrado");
            pS.close();
        } catch (SQLException ex) {
            Logger.getLogger(MatriculasAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
