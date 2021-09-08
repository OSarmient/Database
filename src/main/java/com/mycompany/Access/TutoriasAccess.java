package com.mycompany.Access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.logging.Level;
import java.util.logging.Logger;

import com.mycompany.Utils.DatabaseConnection;

public class TutoriasAccess {

    private static Connection conn = null;

    public static void setTutorias(int idTutoria, String titulo, String descipcion, int año, String idDocenteEncargado){
        String insert = "INSERT INTO tutorias (id_tutoria, titulo, descripcion, año, id_docente_encargado) VALUES (?, ?, ?, ?, ?);";
        try {
            if(conn == null){
                conn = DatabaseConnection.connect();
            }
            PreparedStatement pS = conn.prepareStatement(insert);
            pS.setInt(1, idTutoria);
            pS.setString(2, titulo);
            pS.setString(3, descipcion);
            pS.setInt(4, año);
            pS.setString(5, idDocenteEncargado);
            pS.executeUpdate();
            System.out.println("Tutoria guardada");
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TutoriasAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getTutorias(){
        String query = "SELECT * FROM tutorias;";
        try {
            if(conn == null){
                conn = DatabaseConnection.connect();
            }
            PreparedStatement pS = conn.prepareStatement(query);
            ResultSet rS = pS.executeQuery();
            while(rS.next()){
                int idTutoria = rS.getInt("id_tutoria");
                String titulo = rS.getString("titulo");
                String descripcion = rS.getString("descripcion");
                int año = rS.getInt("año");
                String idDocenteEncargado = rS.getString("id_docente_encargado");

                System.out.println(String.format("Tutoria: %s id: %s año: %s profesor: %s descripción: %s", titulo, idTutoria, año, idDocenteEncargado, descripcion));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TutoriasAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updateTutoriasTitulo(int idTutoria, String titulo){
        String update = "UPDATE tutorias SET titulo = ? WHERE id_tutoria = ?;";
        try {
            if(conn == null){
                conn = DatabaseConnection.connect();
            }
            PreparedStatement pS = conn.prepareStatement(update);
            pS.setString(1, titulo);
            pS.setInt(2, idTutoria);
            pS.executeUpdate();
            System.out.println("Actualizado");
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TutoriasAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteTutorias(int idTutoria){
        String delete = "DELETE FROM tutorias WHERE id_tutoria = ?;";
        try {
            if(conn == null){
                conn = DatabaseConnection.connect();
            }
            PreparedStatement pS = conn.prepareStatement(delete);
            pS.setInt(1, idTutoria);
            pS.executeUpdate();
            System.out.println("Borrado");
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TutoriasAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
