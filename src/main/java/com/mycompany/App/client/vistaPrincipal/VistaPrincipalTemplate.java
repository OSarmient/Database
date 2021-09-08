package com.mycompany.App.client.vistaPrincipal;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.mycompany.App.services.serviceGraphics.ObjGraficosService;

public class VistaPrincipalTemplate extends JFrame {
    private static final long serialVerionUID = 1L;

    private ObjGraficosService sObjGraficos;
    private VistaPrincipalComponent vistaPrincipalComponent;

    private JPanel pNavegacion, pBarra, pPrincipal;
    
    public VistaPrincipalTemplate(VistaPrincipalComponent vistaPrincipalComponent){
        super("Servicio de tutorias");

        this.vistaPrincipalComponent = vistaPrincipalComponent;
        this.vistaPrincipalComponent.getClass();
        sObjGraficos = ObjGraficosService.getService();

        this.crearJPanels();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100, 650);
        setLocationRelativeTo(this);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
    }

    public void crearJPanels(){
        pNavegacion = sObjGraficos.construirJPanel(0, 0, 250, 700, null, null);
		this.add(pNavegacion);

		pBarra = sObjGraficos.construirJPanel(250, 0, 850, 50, null, null);
		this.add(pBarra);

		pPrincipal = sObjGraficos.construirJPanel(250, 50, 850, 600, null, null);
		this.add(pPrincipal);
    }

    public JPanel getPNavegacion() { return this.pNavegacion; }

	public JPanel getPPrincipal() { return this.pPrincipal; }

	public JPanel getPBarra() { return this.pBarra; }
}
