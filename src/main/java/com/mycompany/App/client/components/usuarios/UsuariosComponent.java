package com.mycompany.App.client.components.usuarios;

public class UsuariosComponent {
    private UsuariosTemplate usuariosTemplate;

    public UsuariosComponent(){
        this.usuariosTemplate = new UsuariosTemplate(this);
    }

    public UsuariosTemplate getUsuariosTemplate(){return this.usuariosTemplate;}
}
