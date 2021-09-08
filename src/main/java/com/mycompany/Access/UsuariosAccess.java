package com.mycompany.Access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.logging.Level;
import java.util.logging.Logger;

import com.mycompany.Utils.DatabaseConnection;

public class UsuariosAccess {
    
    private static Connection conn = null;

    public static void setUsuarios(String correoElectronico, String nombres, String apellidos, int edad, String contraseña, int idRol){
        String insert = "INSERT INTO usuarios (correo_electronico, nombres, apellidos, edad, contraseña, id_rol) VALUES(?, ?, ?, ?, ?, ?);";
        try {
            if(conn == null){
                conn = DatabaseConnection.connect();
            }
            PreparedStatement pS = conn.prepareStatement(insert);
            pS.setString(1, correoElectronico);
            pS.setString(2, nombres);
            pS.setString(3, apellidos);
            pS.setInt(4, edad);
            pS.setString(5, contraseña);
            pS.setInt(6, idRol);
            pS.executeUpdate();
            System.out.println("Usuario guardado");
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getUsuarios(){
        String query = "SELECT * FROM usuarios;";
        
        try{
            if(conn == null){
                conn = DatabaseConnection.connect();
            }
            PreparedStatement pS = conn.prepareStatement(query);
            ResultSet rS = pS.executeQuery();
            while(rS.next()){
                String correoElectronico = rS.getString("correo_electronico");
                String nombres = rS.getString("nombres");
                String apellidos = rS.getString("apellidos");
                int edad = rS.getInt("edad");
                String contraseña = rS.getString("contraseña");
                int idRol = rS.getInt("id_rol");

                System.out.println(String.format("Ususario %s %s tiene %s años. Su correo es: %s con contraseña: %s y su rol es %s", 
                                                nombres, apellidos, edad, correoElectronico, contraseña, idRol));
            }
            conn.close();
        }catch(SQLException ex){
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getUsuariosById(String correoElectronico, String contraseña){
        String query = "SELECT * FROM usuarios WHERE correo_electronico = ? AND contraseña = ?;";
        try {
            if(conn==null){
                conn = DatabaseConnection.connect();
            }
            PreparedStatement pS = conn.prepareStatement(query);
            pS.setString(1, correoElectronico);
            pS.setString(2, contraseña);
            ResultSet rS = pS.executeQuery();
            String rScorreoElectronico = rS.getString("correo_electronico");
            String rScontraseña = rS.getString("contraseña");
            int rSidRol = rS.getInt("id_rol");
            return rScorreoElectronico + "_" + rScontraseña+ "_" + rSidRol;
        }catch(SQLException ex){
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void updateUsuariosNombres(String correoElectronico, String nombres){
        String update = "UPDATE usuarios SET nombres = ? WHERE correo_electronico = ?;";
        try {
            if(conn == null){
                conn = DatabaseConnection.connect();
            }
            PreparedStatement pS = conn.prepareStatement(update);
            pS.setString(1, nombres);
            pS.setString(2, correoElectronico);
            pS.executeUpdate();
            System.out.println("Actualizado");
            pS.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteUsuarios(String correoElectonico){
        String delete = "DELETE FROM usuarios WHERE correo_electronico = ?;";
        try {
            if(conn == null){
                conn = DatabaseConnection.connect();
            }
            PreparedStatement pS = conn.prepareStatement(delete);
            pS.setString(1, correoElectonico);
            pS.executeUpdate();
            System.out.println("Borrado");
            pS.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}