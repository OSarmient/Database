package com.mycompany.Access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.logging.Level;
import java.util.logging.Logger;

import com.mycompany.Utils.DatabaseConnection;

public class RolAccess {

    private static Connection conn = null;

    public static void setRol(int idRol, String nombre){
        String insert = "INSERT INTO rol (id_rol, nombre) VALUES(?, ?);";
        try {
            if(conn == null){
                conn = DatabaseConnection.connect();
            }
            PreparedStatement pS = conn.prepareStatement(insert);
            pS.setInt(1, idRol);
            pS.setString(2, nombre);
            pS.executeUpdate();
            System.out.println("Rol guardado");
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(RolAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getRol(){
        String query = "SELECT * FROM rol;";
        try {
            if(conn == null){
                conn = DatabaseConnection.connect();
            }
            PreparedStatement pS = conn.prepareStatement(query);
            ResultSet rS = pS.executeQuery();
            while(rS.next()){
                int idRol = rS.getInt("id_rol");
                String nombre = rS.getString("nombre");
                
                System.out.println(String.format("El ID %s es el rol: ", idRol, nombre));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(RolAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updateRol(int idRol, String nombre){
        String update = "UPDATE rol SET nombre = ? WHERE id_rol = ?;";
        try {
            if(conn == null){
                conn = DatabaseConnection.connect();
            }
            PreparedStatement pS = conn.prepareStatement(update);
            pS.setString(1, nombre);
            pS.setInt(2, idRol);
            pS.executeUpdate();
            System.out.println("Actualizado");
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(RolAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteRol(int idRol){
        String delete = "DELETE FROM rol WHERE id_rol = ?;";
        try {
            if(conn == null){
                conn = DatabaseConnection.connect();
            }
            PreparedStatement pS = conn.prepareStatement(delete);
            pS.setInt(1, idRol);
            pS.executeUpdate();
            System.out.println("Borrado");
            pS.close();
        } catch (SQLException ex) {
            Logger.getLogger(RolAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
