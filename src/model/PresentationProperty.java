/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import entity.Presentation;
import jfxtras.scene.control.agenda.Agenda.AppointmentImpl;

/**
 *
 * @author Maxim
 */
public class PresentationProperty extends AppointmentImpl
{
    private Presentation presentation;
    
    public PresentationProperty withPresentation(Presentation presentation) 
    {
        this.presentation = presentation;
        return this;
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }        
}
