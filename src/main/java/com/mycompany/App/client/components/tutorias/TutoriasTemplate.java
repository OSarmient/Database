package com.mycompany.App.client.components.tutorias;

import java.awt.*;
import javax.swing.*;

public class TutoriasTemplate extends JPanel {

    private TutoriasComponent tutoriasComponent;

    public TutoriasTemplate(TutoriasComponent tutoriasComponent){
        this.tutoriasComponent = tutoriasComponent;

        this.setSize(850, 600);
        this.setBackground(Color.MAGENTA);
        this.setLayout(null);
        this.setVisible(true);
    }
    
}
