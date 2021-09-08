package com.mycompany.App.client.components.matriculas;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.mycompany.App.services.serviceGraphics.GraficosAvanzadosService;
/*
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.mycompany.App.services.serviceGraphics.GraficosAvanzadosService;*/
import com.mycompany.App.services.serviceGraphics.ObjGraficosService;
import com.mycompany.App.services.serviceGraphics.RecursosService;
import com.mycompany.Model.MatriculasModel;

public class ProductosTemplate extends JPanel {
  private JScrollPane pTabla;
  private JPanel pCorner;
  private JTable tabla;
  private JTableHeader header;
  private DefaultTableModel modelo;
  private String [] cabecera={"Matricula", "Estudiante", "Tutoria"};
  private ObjGraficosService sObjGraficos;
  private RecursosService sRecursos;
  private GraficosAvanzadosService sGraficosAvanzados;
  private Color colorGris;

  private JPanel pOpciones, pDatos;
  private JButton bMostrar, bInsertar, bFiltrar, bModificar, bEliminar;
  private JTextField tConsulta;
  private JLabel lTitulo, lInstrucciones, lEslogan;
  private JLabel lId, lIdValor, lIdMatriculas, lIdEstudiantes, lIdTutorias;
  private JTextField tIdMatriculas, tIdEstudiantes, tIdTutorias;

  private ProductosComponent productosComponent;

  public ProductosTemplate(ProductosComponent productosComponent) {
    this.productosComponent = productosComponent;
    this.sObjGraficos = ObjGraficosService.getService();
    this.sRecursos = RecursosService.getService();
    this.sGraficosAvanzados = GraficosAvanzadosService.getService();
    

    this.colorGris = new Color(235,235,235);

    this.crearJPanels();
    this.crearContenidoPOpciones();
    this.crearContenidoPDatos();
    this.crearJTable();

    this.setSize(850, 600);
    this.setBackground(sRecursos.getColorGrisClaro());
    this.setLayout(null);
    this.setVisible(true);
  }

  public void crearJPanels(){
    pOpciones = sObjGraficos.construirJPanel(10, 10, 580, 200, Color.WHITE, null);
    this.add(pOpciones);

    pDatos = sObjGraficos.construirJPanel(600, 10, 240, 580, Color.WHITE, null);
    this.add(pDatos);
  }
  public void crearContenidoPOpciones(){
    // LABEL TITULO--------------------------------------------------------------------
    lTitulo = sObjGraficos.construirJLabel(
        "Edición de Matriculas", 20, 10, 200, 30, null, null, 
        sRecursos.getFontTitulo(), colorGris, sRecursos.getColorGrisOscuro(), sRecursos.getBInferiorAzul(), "c"
    );
    pOpciones.add(lTitulo);

    // TEXTFIELD CONSULTA--------------------------------------------------------------------
    tConsulta = sObjGraficos.construirJTextField(
        "Filtrar...", 30, 60, 380, 40, sRecursos.getFontMediana() , sRecursos.getColorGrisClaro(), 
        sRecursos.getColorGrisOscuro(), colorGris, null, "c"
    );
    tConsulta.addFocusListener(productosComponent);
    pOpciones.add(tConsulta);

    // BOTÓN FILTRAR--------------------------------------------------------------------
    bFiltrar = sObjGraficos.construirJButton(
        "Filtrar", 430, 65, 120, 35, sRecursos.getCMano(), null, sRecursos.getFontLigera(), 
        sRecursos.getColorPrincipal(), Color.WHITE, null, "c", true
    );
    bFiltrar.addMouseListener(productosComponent);
    bFiltrar.addActionListener(productosComponent);
    pOpciones.add(bFiltrar);

    // BOTÓN MOSTRAR--------------------------------------------------------------------
    bMostrar = sObjGraficos.construirJButton(
        "Mostrar", 20, 145, 120, 35, sRecursos.getCMano(), null, sRecursos.getFontLigera(), 
        sRecursos.getColorPrincipal(), Color.WHITE, null, "c", true
    );
    bMostrar.addMouseListener(productosComponent);
    bMostrar.addActionListener(productosComponent);
    pOpciones.add(bMostrar);

    // BOTÓN INSERTAR--------------------------------------------------------------------
    bInsertar = sObjGraficos.construirJButton(
        "Insertar", 160, 145, 120, 35, sRecursos.getCMano(), null, sRecursos.getFontLigera(), 
        sRecursos.getColorPrincipal(), Color.WHITE, null, "c", true
    );
    bInsertar.addMouseListener(productosComponent);
    bInsertar.addActionListener(productosComponent);
    pOpciones.add(bInsertar);

    // BOTÓN MODIFICAR--------------------------------------------------------------------
    bModificar = sObjGraficos.construirJButton(
        "Modificar", 300, 145, 120, 35, sRecursos.getCMano(), null, sRecursos.getFontLigera(), 
        sRecursos.getColorPrincipal(), Color.WHITE, null, "c", true
    );
    bModificar.addMouseListener(productosComponent);
    bModificar.addActionListener(productosComponent);
    pOpciones.add(bModificar);

    // BOTÓN ELIMINAR--------------------------------------------------------------------
    bEliminar= sObjGraficos.construirJButton(
        "Eliminar", 440, 145, 120, 35, sRecursos.getCMano(), null, sRecursos.getFontLigera(), 
        sRecursos.getColorPrincipal(), Color.WHITE, null, "c", true
    );
    bEliminar.addMouseListener(productosComponent);
    bEliminar.addActionListener(productosComponent);
    pOpciones.add(bEliminar);
}

public void crearContenidoPDatos(){
  // LABEL INSTRUCCIONES ----------------------------------------------------------------
  lInstrucciones = sObjGraficos.construirJLabel(
      "<html>Datos de la Matricula<html>", 20, 10, 120, 50, null, null,
      sRecursos.getFontTitulo(), sRecursos.getColorGrisClaro(), sRecursos.getColorGrisOscuro(), null, "l"
  );
  pDatos.add(lInstrucciones);

  // LABEL ESLOGAN ----------------------------------------------------------------
  lEslogan = sObjGraficos.construirJLabel(
      "<html>A continuación puede ver y editar la información de la Matricula<html>", 
      20, 50, 180, 90, null, null, sRecursos.getFontLigera(), sRecursos.getColorGrisClaro(), sRecursos.getColorGrisOscuro(), null, "l"
  );
  pDatos.add(lEslogan);

  // LABEL NOMBRE ----------------------------------------------------------------
  lIdMatriculas = sObjGraficos.construirJLabel(
      "  Matricula:", 20, 180, 160, 30, null, null, 
      sRecursos.getFontLigera(), sRecursos.getColorPrincipalOscuro(), sRecursos.getColorGrisClaro(), null,  "l"
  );
  pDatos.add(lIdMatriculas);

  // TEXTFIELD NOMBRE ----------------------------------------------------------------
  tIdMatriculas = sObjGraficos.construirJTextField(
      "Codigo Matricula", 30, 215, 180, 30, sRecursos.getFontLigera(), colorGris, sRecursos.getColorGrisOscuro(),
      sRecursos.getColorGrisOscuro(),  null, "c"
  );
  tIdMatriculas.addFocusListener(productosComponent);
  pDatos.add(tIdMatriculas);

  // LABEL EDAD ----------------------------------------------------------------
  lIdEstudiantes = sObjGraficos.construirJLabel(
      "  Estudiante:", 20, 265, 160, 30, null, null, sRecursos.getFontLigera(),
      sRecursos.getColorPrincipalOscuro(), sRecursos.getColorGrisClaro(), null, "l"
  );
  pDatos.add(lIdEstudiantes);

  // TEXTFIELD NOMBRE ----------------------------------------------------------------
  tIdEstudiantes = sObjGraficos.construirJTextField(
      "Correo Electronico", 30, 300, 180, 30, sRecursos.getFontLigera(), colorGris, sRecursos.getColorGrisOscuro(),
      sRecursos.getColorGrisOscuro(),  null, "c"
  );
  tIdEstudiantes.addFocusListener(productosComponent);
  pDatos.add(tIdEstudiantes);
  
  // LABEL OFICIO ----------------------------------------------------------------
  lIdTutorias = sObjGraficos.construirJLabel(
      "  Tutoría:", 20, 350, 160, 30, null, null, sRecursos.getFontLigera(),
      sRecursos.getColorPrincipalOscuro(), sRecursos.getColorGrisClaro(), null, "l"
  );
  pDatos.add(lIdTutorias);

  // TEXTFIELD OFICIO ----------------------------------------------------------------
  tIdTutorias = sObjGraficos.construirJTextField(
      "Codigo Tutoria", 30, 385, 180, 30, sRecursos.getFontLigera(), colorGris, sRecursos.getColorGrisOscuro(),
      sRecursos.getColorGrisOscuro(),  null, "c"
  );
  tIdTutorias.addFocusListener(productosComponent);
  pDatos.add(tIdTutorias);
  }

  public void crearJTable(){
      modelo = new DefaultTableModel();
      modelo.setColumnIdentifiers(cabecera);

      tabla = new JTable();
      tabla.setModel(modelo);
      tabla.addMouseListener(productosComponent);
      tabla.setDefaultRenderer(Object.class, sGraficosAvanzados.devolverTablaPersonalizada(
      Color.WHITE, sRecursos.getColorGrisClaro() , sRecursos.getColorPrincipalOscuro(), 
      sRecursos.getColorGrisOscuro(), sRecursos.getFontLigera()
      ));
      
      header = tabla.getTableHeader();
      header.setDefaultRenderer(sGraficosAvanzados.devolverTablaPersonalizada(
      sRecursos.getColorPrincipal(), null , null, Color.WHITE, sRecursos.getFontLigera()
      ));

      pTabla = sObjGraficos.construirPanelBarra(tabla, 10, 220, 580, 370, Color.WHITE, null);
      this.add(pTabla);
      pTabla.getVerticalScrollBar().setUI(
      sGraficosAvanzados.devolverScrollPersonalizado(
          7, 10, Color.WHITE, Color.GRAY, sRecursos.getColorGrisOscuro()
          )
      );

      pCorner = new JPanel();
      pCorner.setBackground(sRecursos.getColorPrincipal());
      pTabla.setCorner(JScrollPane.UPPER_RIGHT_CORNER, pCorner);

      header.setPreferredSize(new Dimension(580, 30));
      tabla.setRowHeight(40);
      tabla.setShowHorizontalLines(false);
      tabla.setShowVerticalLines(false);
  }

    public JButton getBMostrar() { return bMostrar; }

    public JButton getBInsertar() { return bInsertar; }

    public JButton getBModificar() { return bModificar; }

    public JButton getBEliminar() { return bEliminar; }

    public JButton getBFiltrar() { return bFiltrar; }

    public JLabel getLIdValor() { return lIdValor; }

    public JTextField getTIdMatriculas() { return tIdMatriculas; }

    public JTextField getTIdEstudiantes() { return tIdEstudiantes; }

    public JTextField getTIdTutorias() { return tIdTutorias; }

    public JTextField getTConsulta() { return tConsulta; }
    
    public JTable getTabla(){ return tabla; }

    public DefaultTableModel getModelo(){ return modelo;}
}