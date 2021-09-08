package com.mycompany.App.client.components.usuarios;

import java.awt.*;
import javax.swing.*;

public class UsuariosTemplate extends JPanel{

    private UsuariosComponent usuariosComponent;

    public UsuariosTemplate(UsuariosComponent usuariosComponent) {
        this.usuariosComponent = usuariosComponent;

        this.setSize(850, 600);
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(null);
        this.setVisible(true);
    }
    
}
