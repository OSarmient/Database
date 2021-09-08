package com.mycompany.App.client.components.tutorias;

public class TutoriasComponent {
    private TutoriasTemplate tutoriasTemplate;

    public TutoriasComponent(){
        this.tutoriasTemplate = new TutoriasTemplate(this);
    }

    public TutoriasTemplate getTutoriasTemplate(){return this.tutoriasTemplate;}
}
