package com.mycompany.App;

import javax.swing.SwingUtilities;

import com.mycompany.App.client.login.LoginComponent;

public class Main {
    public static void main(String[] args) {
        Runnable init = new Runnable(){
            @Override
            public void run(){
                LoginComponent vista = new LoginComponent();
                vista.getClass();
            }
        };
        SwingUtilities.invokeLater(init);
            //new Window();
    }
}
