package com.mycompany.App.client.components.matriculas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.mycompany.App.services.serviceGraphics.RecursosService;
import com.mycompany.App.services.servicesLogic.MatriculasService;
import com.mycompany.Model.MatriculasModel;

public class ProductosComponent implements ActionListener, MouseListener, FocusListener {
  private ProductosTemplate matriculaTemplate;
  private MatriculasService sMatriculas;
  private MatriculasModel matricula;
  private String[] placeholdes = {"Codigo Matricula","Correo Electronico","Codigo Tutoria","Filtrar..."};

    public ProductosComponent() {
      sMatriculas = MatriculasService.getService();
      matriculaTemplate = new ProductosTemplate(this);
    }

  public ProductosTemplate getMatriculasTemplate(){return this.matriculaTemplate;}

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == matriculaTemplate.getBMostrar())
        mostrarRegistrosTabla();
    if(e.getSource() == matriculaTemplate.getBInsertar())
        insertarRegistroTabla();
    if(e.getSource() == matriculaTemplate.getBModificar())
        modificarRegistroTabla();
    if(e.getSource() == matriculaTemplate.getBEliminar())
        eliminarRegistroTabla();
    if(e.getSource() == matriculaTemplate.getBFiltrar())
        filtrarRegistrosTabla();
  }

  @Override
  public void focusGained(FocusEvent e) {
    JTextField textField = ((JTextField) e.getSource());
    textField.setBorder(RecursosService.getService().getBAzul());
    if(
        textField.getText().equals(placeholdes[0]) || textField.getText().equals(placeholdes[1]) ||
        textField.getText().equals(placeholdes[2]) || textField.getText().equals(placeholdes[3]) ||
        textField.getText().equals(placeholdes[4]) || textField.getText().equals(placeholdes[5]) 
    )
        textField.setText("");
  }

  @Override
  public void focusLost(FocusEvent e) {
    JTextField textField = ((JTextField) e.getSource());
    textField.setBorder(null);
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    if(e.getSource() instanceof JTable){
      int fila = matriculaTemplate.getTabla().getSelectedRow();
        matricula = sMatriculas.devolverMatricula(fila);
        matricula.setIdMatriculas(Integer.parseInt(matriculaTemplate.getTIdMatriculas().getText()));
        matricula.setIdEstudiante(matriculaTemplate.getTIdEstudiantes().getText());
        matricula.setIdTutoria(Integer.parseInt(matriculaTemplate.getTIdTutorias().getText()));

    }
  }

  @Override
  public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    if(e.getSource() instanceof JButton){
      JButton boton = ((JButton) e.getSource());
      boton.setBackground(RecursosService.getService().getColorPrincipalOscuro());
    }
  }

  @Override
  public void mouseExited(MouseEvent e) {
    if(e.getSource() instanceof JButton){
      JButton boton = ((JButton) e.getSource());
      boton.setBackground(RecursosService.getService().getColorPrincipal());
    }
  }

  public void restaurarValores(){
      matriculaTemplate.getLIdValor().setText(sMatriculas.devolverCantidadMatriculas()+"");
      matriculaTemplate.getTIdMatriculas().setText(placeholdes[0]);
      matriculaTemplate.getTIdEstudiantes().setText(placeholdes[1]);
      matriculaTemplate.getTIdTutorias().setText(placeholdes[2]);
  }
  
  public void mostrarRegistrosTabla(){
    for(int i=0; i<sMatriculas.devolverCantidadMatriculas(); i++){
        matricula = sMatriculas.devolverMatricula(i);
        this.agregarRegistro(matricula);
    }
  }

  public void insertarRegistroTabla(){
      matricula = new MatriculasModel();
      matricula.setIdMatriculas(Integer.parseInt(matriculaTemplate.getTIdMatriculas().getText()));
      matricula.setIdEstudiante(matriculaTemplate.getTIdEstudiantes().getText());
      matricula.setIdTutoria(Integer.parseInt(matriculaTemplate.getTIdTutorias().getText()));
      this.agregarRegistro(matricula);
      sMatriculas.agregarMatricula(matricula);
      restaurarValores();
  }
  
  public void modificarRegistroTabla(){
    int fSeleccionada = matriculaTemplate.getTabla().getSelectedRow();
    if(fSeleccionada != -1){
      matriculaTemplate.getModelo().setValueAt(
        matriculaTemplate.getTIdMatriculas().getText(), fSeleccionada, 0
        );
        matriculaTemplate.getModelo().setValueAt(
          matriculaTemplate.getTIdEstudiantes().getText(), fSeleccionada, 1
        );
        matriculaTemplate.getModelo().setValueAt(
          matriculaTemplate.getTIdTutorias().getText(), fSeleccionada, 2
        );
        matricula = sMatriculas.devolverMatricula(fSeleccionada);
        matricula.setIdMatriculas(Integer.parseInt(matriculaTemplate.getTIdMatriculas().getText()));
        matricula.setIdEstudiante(matriculaTemplate.getTIdEstudiantes().getText());
        matricula.setIdTutoria(Integer.parseInt(matriculaTemplate.getTIdTutorias().getText()));

        restaurarValores();
    }
    else
        JOptionPane.showMessageDialog(null,"seleccione una fila", "Error" , JOptionPane.ERROR_MESSAGE);
  }
  
  public void eliminarRegistroTabla(){
    int fSeleccionada = matriculaTemplate.getTabla().getSelectedRow();
    if(fSeleccionada!= -1)
      matriculaTemplate.getModelo().removeRow(fSeleccionada);
    else
        JOptionPane.showMessageDialog(null,"seleccione una fila","Error",JOptionPane.ERROR_MESSAGE);

  }
  
  public void filtrarRegistrosTabla(){
    TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(matriculaTemplate.getModelo());
    matriculaTemplate.getTabla().setRowSorter(trs);
    trs.setRowFilter(RowFilter.regexFilter(matriculaTemplate.getTConsulta().getText()));
  }
  
  public void agregarRegistro(MatriculasModel matricula){
    matriculaTemplate.getModelo().addRow(
        new Object[]{matricula.getIdMatriculas(), matricula.getIdEstudiante(), matricula.getIdTutoria()}
    );
  }
}