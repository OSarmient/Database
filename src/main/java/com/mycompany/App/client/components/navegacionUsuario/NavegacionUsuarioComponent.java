package com.mycompany.App.client.components.navegacionUsuario;

import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import javax.swing.*;

import com.mycompany.App.client.vistaPrincipal.VistaPrincipalComponent;
import com.mycompany.App.services.serviceGraphics.RecursosService;

public class NavegacionUsuarioComponent extends MouseAdapter implements ActionListener, MouseListener{

    private NavegacionUsuarioTemplate navegacionUsuarioTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;

    public NavegacionUsuarioComponent(VistaPrincipalComponent vistaPrincipalComponent){
        this.navegacionUsuarioTemplate = new NavegacionUsuarioTemplate(this);
        this.vistaPrincipalComponent = vistaPrincipalComponent;
    }

    public NavegacionUsuarioTemplate getNavegacionUsuarioTemplate() {
        return this.navegacionUsuarioTemplate;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.vistaPrincipalComponent.mostrarComponente(e.getActionCommand().trim());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JButton boton = ((JButton) e.getSource());
        boton.setContentAreaFilled(true);
        boton.setBackground(RecursosService.getService().getColorPrincipalOscuro()); 
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton boton = ((JButton) e.getSource());
        boton.setContentAreaFilled(false);
    }
    
}
