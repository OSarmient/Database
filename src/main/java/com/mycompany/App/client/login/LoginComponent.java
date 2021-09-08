package com.mycompany.App.client.login;

import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JOptionPane;
import javax.swing.*;

import com.mycompany.App.client.vistaPrincipal.VistaPrincipalComponent;

public class LoginComponent extends MouseAdapter implements ActionListener {

    private LoginTemplate loginTemplate;
    private VistaPrincipalComponent vistaPrincipal;
    private JButton boton;
    private JTextField text;
    private JLabel label;
    private String[] placeholders = { "Nombre Usuario", "Clave Usuario" };

    public LoginComponent(){
        this.loginTemplate = new LoginTemplate(this);
    }

    public LoginTemplate getLoginTemplate(){return this.loginTemplate;}


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginTemplate.getBEntrar()){
            this.mostrarDatosUsuario();
            this.entrar();
        }
        if(e.getSource()== loginTemplate.getBCerrar()){
            System.exit(0);
        }
        if(e.getSource() == loginTemplate.getBOpcion1()){
            JOptionPane.showMessageDialog(null, "Boton Opción", "Advertencia", 1);
        }
        if(e.getSource()==loginTemplate.getBRegistrarse()){
            JOptionPane.showMessageDialog(null, "Boton Registro", "Advertencia", 1);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JTextField) {
            text = ((JTextField) e.getSource());
            label = loginTemplate.getLabels(text);
            label.setIcon(loginTemplate.getIAzul(label));
            text.setForeground(loginTemplate.getRecursosService().getColorPrincipal());
            text.setBorder(loginTemplate.getRecursosService().getBInferiorAzul());
            if (
              text.getText().equals(placeholders[0]) || 
              text.getText().equals(placeholders[1])
            ) 
              text.setText("");
          }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() instanceof JButton){
            boton = ((JButton) e.getSource());
            boton.setBackground(loginTemplate.getRecursosService().getColorPrincipalOscuro()); 
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() instanceof JButton){
            boton = ((JButton) e.getSource());
            boton.setBackground(loginTemplate.getRecursosService().getColorPrincipal());  
        } 
    }

    public void mostrarDatosUsuario(){
        String nombreUsuario = loginTemplate.getTNombreUsuario().getText();
        String claveUsuario = new String(loginTemplate.getTClaveUsuario().getPassword());
        String tipoUsuario = ((String) loginTemplate.getCbTipoUsuario().getSelectedItem());
        
        JOptionPane.showMessageDialog(
            null,
            "Nombre Usuario: " + nombreUsuario +
            "\nClave Usuario: " + claveUsuario + 
            "\nTipo Usuario: " + tipoUsuario,
            "Advertencia", 
            1);
    }

    public void entrar(){
        if(vistaPrincipal == null)
            this.vistaPrincipal = new VistaPrincipalComponent(this);
        else
            this.vistaPrincipal.getVistaPrincipalTemplate().setVisible(true);    
        loginTemplate.setVisible(false);
    }
    
}
