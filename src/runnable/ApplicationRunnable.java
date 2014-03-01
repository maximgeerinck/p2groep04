/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package runnable;

import gui.GraphicApplication;

/**
 *
 * @author Maxim
 */
public class ApplicationRunnable implements Runnable
{
    GraphicApplication application;

    public ApplicationRunnable()
    {
        application = new GraphicApplication();
    }
    
    @Override
    public void run() {
        application.initGUI();
    }
    
}
