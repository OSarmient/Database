/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection connect(){
        String dbURL = "jdbc:mysql://localhost:3306/roles";
        String username = "Omar";
        String password = "Kokoriko170.";
        //connectar
        try{
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            /*if(connection != null){
                System.out.println("Conectado");
            }*/
            return connection;
        }catch(SQLException ex){
            ex.printStackTrace();
            //System.err.println("No Conectado");

        }
        return null;
    }
}
