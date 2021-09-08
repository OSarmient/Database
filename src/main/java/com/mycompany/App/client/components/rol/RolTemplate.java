package com.mycompany.App.client.components.rol;

import java.awt.*;
import javax.swing.*;

public class RolTemplate extends JPanel{

    private RolComponent rolComponent;

    public RolTemplate(RolComponent rolComponent) {
        this.rolComponent = rolComponent;

        this.setSize(850, 600);
        this.setBackground(Color.CYAN);
        this.setLayout(null);
        this.setVisible(true);
    }
    
}
