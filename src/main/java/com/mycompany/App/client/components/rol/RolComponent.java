package com.mycompany.App.client.components.rol;

public class RolComponent {
    private RolTemplate rolTemplate;

    public RolComponent(){
        this.rolTemplate = new RolTemplate(this);
    }

    public RolTemplate getRolTemplate(){return this.rolTemplate;}
    
}
