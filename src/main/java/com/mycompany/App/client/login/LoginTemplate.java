package com.mycompany.App.client.login;

import java.awt.*;
import javax.swing.*;

import com.mycompany.App.services.serviceGraphics.ObjGraficosService;
import com.mycompany.App.services.serviceGraphics.RecursosService;

public class LoginTemplate extends JFrame {

    private RecursosService sRecursos;
    private ObjGraficosService sObjGraficos;
    private LoginComponent loginComponent;

    private JLabel lTituloApp, lEslogan, lTituloLogin;
    private JLabel lFondo, lSvg1, lLogo, lUsuario, lClave, lFacebook, lTwitter, lYoutube;
    private JPanel pDerecha, pIzquierda;
    private JTextField tNombreUsuario;
    private JPasswordField tClaveUsuario;
    private JComboBox cbTipoUsuario;
    private JButton bEntrar, bCerrar, bRegistrarse, bOpcion1, bOpcion2, bOpcion3;

    private ImageIcon iFondo, iLogo;
    private ImageIcon iSvg1, iUsuario2, iClave2, iPunto1, iFacebook1, iTwitter1, iYoutube1, iDimAux;

    
    public LoginTemplate(LoginComponent loginComponent){

        this.loginComponent = loginComponent;

        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();

        this.crearObjetosDecoradores();
        this.crearJPanels();
        this.crearJTextFields();
        this.crearJPasswordFields();
        this.crearJComboBoxes();
        this.crearJButtons();
        this.crearJLabels();

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 500);
        setLocationRelativeTo(this);
        setUndecorated(true);
        setLayout(null);
        setVisible(true);
    }
    
    public JButton getBCerrar(){ return this.bCerrar; }

    public JButton getBEntrar(){ return this.bEntrar; }

    public JButton getBRegistrarse(){ return this.bRegistrarse; }

    public JButton getBOpcion1(){ return this.bOpcion1; }

    public JTextField getTNombreUsuario(){ return this.tNombreUsuario; }

    public JPasswordField getTClaveUsuario(){ return this.tClaveUsuario; }

    public JComboBox<String> getCbTipoUsuario(){ return this.cbTipoUsuario; }

    public RecursosService getRecursosService() { return sRecursos; }

    public JLabel getLabels(JTextField text) {
        if (text == tNombreUsuario) return lUsuario;
        if (text == tClaveUsuario) return lClave;
        return null;
      }
    
      public ImageIcon getIAzul(JLabel label) {
        if (label == lUsuario) 
          iDimAux = new ImageIcon(
            iUsuario2.getImage()
              .getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
          );
        if (label == lClave) 
          iDimAux = new ImageIcon(
            iClave2.getImage()
              .getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
          );
        return iDimAux;
      }

    public void crearObjetosDecoradores(){
        iFondo = new ImageIcon("C:/Users/Usuario/Documents/NetBeansProjects/database/Resources/Images/fondo.png");
        iLogo = new ImageIcon("C:/Users/Usuario/Documents/NetBeansProjects/database/Resources/Images/logo_transparent.png");
        iUsuario2 = new ImageIcon("C:/Users/Usuario/Documents/NetBeansProjects/database/Resources/Images/usuario2.png");
        iClave2 = new ImageIcon("C:/Users/Usuario/Documents/NetBeansProjects/database/Resources/Images/clave2.png");
        iPunto1 = new ImageIcon("C:/Users/Usuario/Documents/NetBeansProjects/database/Resources/Images/punto1.png");
        iFacebook1 = new ImageIcon("C:/Users/Usuario/Documents/NetBeansProjects/database/Resources/Images/facebook1.png");
        iTwitter1 = new ImageIcon("C:/Users/Usuario/Documents/NetBeansProjects/database/Resources/Images/twitter1.png");
        iYoutube1 = new ImageIcon("C:/Users/Usuario/Documents/NetBeansProjects/database/Resources/Images/youtube1.png");
        iSvg1 = new ImageIcon("C:/Users/Usuario/Documents/NetBeansProjects/database/Resources/Images/imagen1.png");
    }

    public void crearJPanels(){
        pDerecha = sObjGraficos.construirJPanel(600, 0, 400, 500, Color.WHITE, null);
        this.add(pDerecha);

        pIzquierda = sObjGraficos.construirJPanel(0, 0, 600, 500, Color.WHITE, null);
        this.add(pIzquierda);
    }

    public void crearJTextFields(){
        tNombreUsuario = sObjGraficos.construirJTextField(
        "Nombre Usuario", 
        (pDerecha.getWidth() - 260) / 2, 130, 260, 40,
        null, 
        Color.WHITE, 
        sRecursos.getColorGrisOscuro(), 
        sRecursos.getColorGrisOscuro(), 
        sRecursos.getBInferiorGris(),
        "c"
        );
        tNombreUsuario.addMouseListener(loginComponent);
        pDerecha.add(tNombreUsuario);
    }

    public void crearJButtons(){
        // BOTÓN CERRAR-----------------------------------------------------------------------------
        iDimAux = new ImageIcon(
            sRecursos.getICerrar().getImage()
            .getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
        );
        bCerrar = sObjGraficos.construirJButton(
            null, 
            350, 10, 45, 30, 
            sRecursos.getCMano(), 
            iDimAux, 
            null, null, null, null, 
            "c", 
            false
        );
        bCerrar.addActionListener(loginComponent);
        pDerecha.add(bCerrar);
        
        // BOTÓN ENTRAR-----------------------------------------------------------------------------
        bEntrar = sObjGraficos.construirJButton(
            "Entrar", 
            (pDerecha.getWidth() - 250) / 2, 330, 250, 45,
            sRecursos.getCMano(), 
            null, null, 
            sRecursos.getColorPrincipal(), 
            Color.WHITE, 
            null, 
            "c", 
            true
        );
        bEntrar.addMouseListener(loginComponent);
        bEntrar.addActionListener(loginComponent);
        pDerecha.add(bEntrar);
  
        // BOTÓN REGISTRARSE-----------------------------------------------------------------------
        bRegistrarse = sObjGraficos.construirJButton(
            "Registrarse", 
            240, 460, 145, 35, 
            sRecursos.getCMano(), 
            null, null,
            sRecursos.getColorPrincipal(), 
            Color.WHITE, 
            null, 
            "c", 
            true
        );
        bRegistrarse.addMouseListener(loginComponent);
        bRegistrarse.addActionListener(loginComponent);
        pDerecha.add(bRegistrarse);

        iDimAux = new ImageIcon(
        iPunto1.getImage()
            .getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING)
        );

        // BOTÓN OPCIÓN 1-----------------------------------------------------------------------------
        bOpcion1 = sObjGraficos.construirJButton(
            null, 
            10, 220, 30, 20, 
            sRecursos.getCMano(), 
            iDimAux, 
            null, null, null, null, 
            "c", 
            false
        );
        bOpcion1.addActionListener(loginComponent);
        pIzquierda.add(bOpcion1);

        // BOTÓN OPCIÓN 2-----------------------------------------------------------------------------
        bOpcion2 = sObjGraficos.construirJButton(
            null,
            10, 250, 30, 20, 
            sRecursos.getCMano(), 
            iDimAux, 
            null, null, null, null, 
            "c", 
            false
        );
        pIzquierda.add(bOpcion2);

        // BOTÓN OPCIÓN 3-----------------------------------------------------------------------------
        bOpcion3 = sObjGraficos.construirJButton(
            null,
            10, 280, 30, 20, 
            sRecursos.getCMano(), 
            iDimAux, 
            null, null, null, null, 
            "c", 
            false
            );
            pIzquierda.add(bOpcion3);
    }

    public void crearJLabels(){
        // LABEL LOGO-----------------------------------------------------------------------------
        iDimAux = new ImageIcon(
            iLogo.getImage()
            .getScaledInstance(60, 60, Image.SCALE_AREA_AVERAGING)
        );
        lLogo = sObjGraficos.construirJLabel(
            null, 
            40, 15, 60, 60, 
            sRecursos.getCMano(),
            iDimAux, 
            null, null, null, null,
            "c"
        );
        pIzquierda.add(lLogo);

        // LABEL TITULO APP-----------------------------------------------------------------------------
        lTituloApp = sObjGraficos.construirJLabel(
            "Servicio de tutorias", 
            100, 20, 240, 30, 
            null, null,
            sRecursos.getFontTPrincipal(), 
            null,
            Color.WHITE, 
            null, 
            "c"
        );
        pIzquierda.add(lTituloApp);

        // LABEL SVG-----------------------------------------------------------------------------
        iDimAux = new ImageIcon(
        iSvg1.getImage()
            .getScaledInstance(500, 345, Image.SCALE_AREA_AVERAGING)
        );
        lSvg1 = sObjGraficos.construirJLabel(
        null, 
        100, 100, 500, 345, 
        null,
        iDimAux, 
        null, null, null, null,
        "c"
        );
        pIzquierda.add(lSvg1);

        // LABEL ESLOGAN-----------------------------------------------------------------------------
        lEslogan = sObjGraficos.construirJLabel(
            "Te ayudamos en todo", 
            (pDerecha.getWidth() - 130) / 2, 60, 130, 20, 
            null, null,
            sRecursos.getFontSubtitulo(), 
            null, 
            sRecursos.getColorGrisOscuro(), 
            null,
            "c"
        );
        pDerecha.add(lEslogan);

        // LABEL TITULO LOGIN-----------------------------------------------------------------------------
        lTituloLogin = sObjGraficos.construirJLabel(
        "Registra tus Datos", 
        (pDerecha.getWidth() - 150) / 2, 80, 150, 30,
        null, null,
        sRecursos.getFontTitulo(),
        null, 
        sRecursos.getColorGrisOscuro(), 
        null,
        "c"
        );
        pDerecha.add(lTituloLogin);
            
        // LABEL USUARIO-----------------------------------------------------------------------------
        iDimAux = new ImageIcon(
            iUsuario2.getImage()
            .getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
        );
        lUsuario = sObjGraficos.construirJLabel(
            null, 
            40, 140, 30, 30, 
            null,
            iDimAux, 
            null, null, null, null,
            "c"
        );
        pDerecha.add(lUsuario);

        // LABEL CLAVE-----------------------------------------------------------------------------
        iDimAux = new ImageIcon(
            iClave2.getImage()
            .getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
        );
        lClave = sObjGraficos.construirJLabel(
            null, 
            40, 270, 30, 30, 
            null,
            iDimAux, 
            null, null, null, null,
            "c"
        );
        pDerecha.add(lClave);


        // LABEL FACEBOOK-----------------------------------------------------------------------------
        iDimAux = new ImageIcon(
            iFacebook1.getImage()
            .getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
        );
        lFacebook = sObjGraficos.construirJLabel(
            null, 
            20, 460, 30, 30, 
            sRecursos.getCMano(),
            iDimAux, 
            null, null, null, null,
            "c"
        );
        pIzquierda.add(lFacebook);
    
        // LABEL TWITTER-----------------------------------------------------------------------------
        iDimAux = new ImageIcon(
            iTwitter1.getImage()
            .getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
        );
        lTwitter = sObjGraficos.construirJLabel(
            null, 
            60, 460, 30, 30, 
            sRecursos.getCMano(),
            iDimAux, 
            null, null, null, null,
            "c"
        );
        pIzquierda.add(lTwitter);
    
        // LABEL YOUTUBE-----------------------------------------------------------------------------
        iDimAux = new ImageIcon(
            iYoutube1.getImage()
            .getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
            );
        lYoutube = sObjGraficos.construirJLabel(
            null, 
            100, 460, 30, 30, 
            sRecursos.getCMano(),
            iDimAux, 
            null, null, null, null,
            "c"
        );
        pIzquierda.add(lYoutube);

        // LABEL FONDO-----------------------------------------------------------------------------
        iDimAux = new ImageIcon(
            iFondo.getImage()
            .getScaledInstance(600, 600, Image.SCALE_AREA_AVERAGING)
        );
        lFondo = sObjGraficos.construirJLabel(
            null, 
            0, 0, 600, 600, 
            null,
            iDimAux, 
            null, null, null, null,
            "c"
        );
        pIzquierda.add(lFondo);
    }

    public void crearJPasswordFields(){
        tClaveUsuario = sObjGraficos.construirJPasswordField(
        "Clave Usuario", 
        (pDerecha.getWidth() - 260) / 2, 260, 260, 40,
        null, null, 
        sRecursos.getColorGrisOscuro(), 
        sRecursos.getColorGrisOscuro(), 
        sRecursos.getBInferiorGris(), 
        "c"
        );
        tClaveUsuario.addMouseListener(loginComponent);
        pDerecha.add(tClaveUsuario);
    }

    public void crearJComboBoxes(){
        cbTipoUsuario = sObjGraficos.construirJComboBox(
        "Estudiante_Docente", 
        (pDerecha.getWidth() - 220) / 2, 210, 220, 30, 
        null,
        Color.WHITE, 
        sRecursos.getColorPrincipal(), 
        "c"
        );
        pDerecha.add(cbTipoUsuario);
    }
}
