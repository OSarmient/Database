package com.mycompany.App.services.serviceGraphics;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.io.File;
import java.io.IOException;

public class RecursosService {

    private Color colorPrincipal, colorGrisOscuro, colorSecundario, colorPrincipalOscuro, colorGrisClaro;
    private Font fontTPrincipal, fontTitulo, fontSubtitulo, fontLigera, fontMediana;
    private Cursor cMano;
    private Border bInferiorAzul, bInferiosGris, bAzul;
    private ImageIcon iCerrar, iMinimizar;

    static private RecursosService servico;

    private RecursosService(){
        generarFuentes();

        this.crearColores();
        this.crearFuentes();
        this.crearCursores();
        this.crearBordes();
        this.crearImagenes();
    }

    public Color getColorPrincipal(){return colorPrincipal;}

    public Color getColorGrisOscuro(){return colorGrisOscuro;}

    public Color getColorSecundario(){return colorSecundario;}

    public Color getColorPrincipalOscuro(){return colorPrincipalOscuro;}

    public Color getColorGrisClaro(){return colorGrisClaro;}

    public Font getFontTPrincipal(){return fontTPrincipal;}

    public Font getFontTitulo(){return fontTitulo;}

    public Font getFontSubtitulo(){return fontSubtitulo;}

    public Font getFontLigera(){return fontLigera;}

    public Font getFontMediana() {return fontMediana;}

    public Cursor getCMano(){return cMano;}

    public Border getBInferiorAzul(){return bInferiorAzul;}

    public Border getBInferiorGris(){return bInferiosGris;}

    public Border getBAzul(){return bAzul;}

    public ImageIcon getICerrar(){return iCerrar;}

    public ImageIcon getIMinimizar(){return iMinimizar;}

    private void crearColores(){
        colorPrincipal = new Color(60, 78, 120);
        colorGrisOscuro = new Color(80, 80, 80);
        colorSecundario = new Color(151, 0, 158);
        colorPrincipalOscuro = new Color(30, 48, 90);
        colorGrisClaro = new Color(249, 246, 249);
    }

    private void crearFuentes(){
        fontTPrincipal = new Font("Rockwell Extra Bold", Font.PLAIN, 20);
        fontTitulo = new Font("Calibri (Cuerpo)", Font.BOLD, 17);
        fontSubtitulo = new Font("Forte", Font.PLAIN, 13);
        fontMediana = new Font("LuzSans-Book", Font.PLAIN, 15);
        fontLigera = new Font("LuzSans-Book", Font.PLAIN, 12);
    }

    private void crearCursores(){cMano = new Cursor(Cursor.HAND_CURSOR);}

    private void crearBordes(){
        bInferiorAzul = BorderFactory.createMatteBorder(0, 0, 2, 0, colorPrincipal);
        bInferiosGris = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY);
        bAzul = BorderFactory.createLineBorder(colorPrincipal, 2, true);
    }

    private void crearImagenes(){
        iCerrar = new ImageIcon("C:/Users/Usuario/Documents/NetBeansProjects/database/Resources/Images/cerrar.png");
        iMinimizar = new ImageIcon("C:/Users/Usuario/Documents/NetBeansProjects/database/Resources/Images/minimizar.png");
    }

    private void generarFuentes(){
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(
                Font.TRUETYPE_FONT,
                new File("C:/Users/Usuario/Documents/NetBeansProjects/database/Resources/Fonts/LUZRO.ttf")
            ));
        } catch (IOException | FontFormatException e) {
            System.out.println(e);
        }
    }
    public static RecursosService getService(){
        if(servico == null){
            servico = new RecursosService();
        }
        return servico;
    }
    
}
