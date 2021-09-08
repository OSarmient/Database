package com.mycompany.App.client.vistaPrincipal;

import java.awt.Frame;

import com.mycompany.App.client.components.barraTitulo.BarraTituloComponent;
import com.mycompany.App.client.components.matriculas.ProductosComponent;
import com.mycompany.App.client.components.navegacionUsuario.NavegacionUsuarioComponent;
import com.mycompany.App.client.components.rol.RolComponent;
import com.mycompany.App.client.components.tutorias.TutoriasComponent;
import com.mycompany.App.client.components.usuarios.UsuariosComponent;
import com.mycompany.App.client.login.LoginComponent;

public class VistaPrincipalComponent {
    private VistaPrincipalTemplate vistaPrincipalTemplate;
    private BarraTituloComponent barraTituloComponent;
    private NavegacionUsuarioComponent navegacionUsuarioComponent;
    private LoginComponent loginComponent;

    private UsuariosComponent usuariosComponent;
    private RolComponent rolComponent;
    private TutoriasComponent tutoriasComponent;
    private ProductosComponent matriculasComponent;

    public VistaPrincipalComponent(LoginComponent loginComponent){
        this.loginComponent = loginComponent;
        this.vistaPrincipalTemplate = new VistaPrincipalTemplate(this);
        this.barraTituloComponent = new BarraTituloComponent(this);
        this.navegacionUsuarioComponent = new NavegacionUsuarioComponent(this);

        this.usuariosComponent = new UsuariosComponent();
        this.rolComponent = new RolComponent();
        this.tutoriasComponent = new TutoriasComponent();
        this.matriculasComponent = new ProductosComponent();

        vistaPrincipalTemplate.getPBarra().add(barraTituloComponent.getBarraTituloTemplate());
        vistaPrincipalTemplate.getPNavegacion().add(navegacionUsuarioComponent.getNavegacionUsuarioTemplate());
    }

    public void moverVentana(int posicionX, int posicionY){
        this.vistaPrincipalTemplate.setLocation(posicionX, posicionY);
    }

    public VistaPrincipalTemplate getVistaPrincipalTemplate(){
        return this.vistaPrincipalTemplate;
    }

    public void cerrar(){
        System.exit(0);
    }

    public void minimizar(){
        this.vistaPrincipalTemplate.setExtendedState(Frame.ICONIFIED);
    }

    public void mostrarComponente(String comando){
        vistaPrincipalTemplate.getPPrincipal().removeAll();
        switch(comando){
            case "Usuarios":
                if(this.usuariosComponent == null)
                    this.usuariosComponent = new UsuariosComponent();
                vistaPrincipalTemplate.getPPrincipal().add(usuariosComponent.getUsuariosTemplate());
                break;
            case "Rol":
                if(this.rolComponent == null)
                    this.rolComponent = new RolComponent();
                vistaPrincipalTemplate.getPPrincipal().add(rolComponent.getRolTemplate());
                break;
            case "Tutorias":
                if(this.tutoriasComponent == null)
                    this.tutoriasComponent = new TutoriasComponent();
                vistaPrincipalTemplate.getPPrincipal().add(tutoriasComponent.getTutoriasTemplate());
                break;
            case "Matriculas":
                if(this.matriculasComponent == null)
                    this.matriculasComponent = new ProductosComponent();
                vistaPrincipalTemplate.getPPrincipal().add(matriculasComponent.getMatriculasTemplate());
                break;
            case "Cerrar Sesión":
                this.loginComponent.getLoginTemplate().setVisible(true);
                this.vistaPrincipalTemplate.setVisible(false);
                break;
        }
        vistaPrincipalTemplate.repaint();
    }
}
