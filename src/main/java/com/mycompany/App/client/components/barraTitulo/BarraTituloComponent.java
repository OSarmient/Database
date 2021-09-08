package com.mycompany.App.client.components.barraTitulo;

import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.mycompany.App.client.vistaPrincipal.VistaPrincipalComponent;

public class BarraTituloComponent extends MouseAdapter implements ActionListener {

    private BarraTituloTemplate barraTituloTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    private int posicionInicialX, posicionInicialY;

    public BarraTituloComponent(VistaPrincipalComponent vistaPrincipalComponent){
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        this.barraTituloTemplate = new BarraTituloTemplate(this);
    }

    public BarraTituloTemplate getBarraTituloTemplate(){
        return this.barraTituloTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == barraTituloTemplate.getBMinimizar()){
            vistaPrincipalComponent.minimizar();
        }   
        if(e.getSource() == barraTituloTemplate.getBCerrar()){
            vistaPrincipalComponent.cerrar();
        }     
    }

    @Override
    public void mousePressed(MouseEvent e) {
        posicionInicialX = e.getX()+250;
        posicionInicialY = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.vistaPrincipalComponent.moverVentana(
            e.getXOnScreen() - posicionInicialX, 
            e.getYOnScreen() - posicionInicialY
        );
    }
    
}
