/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import de.jaret.util.ui.timebars.TimeBarViewerInterface;
import de.jaret.util.ui.timebars.mod.DefaultIntervalModificator;
import de.jaret.util.ui.timebars.model.TimeBarModel;
import de.jaret.util.ui.timebars.swing.TimeBarViewer;
import de.jaret.util.ui.timebars.swing.renderer.OldDefaultTimeScaleRenderer;
import entity.Presentation;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Appointment;
import model.CalendarModel;
import model.ModelCreator;
import model.PresentationModificator;
import swing.CalendarControlPanel;
import swing.renderer.CalendarGridRenderer;
import swing.renderer.PresentationRenderer;

/**
 *
 * @author Maxim
 */
public class GraphicApplication 
{
    private JFrame mainFrame;
    private JFrame ptFrame;
    private TimeBarViewer _tbv;
    
    public GraphicApplication() 
    {
        
    }
    
    public void initGUI() 
    {
        //FRAME: PRESENTATIE TONEN
        mainFrame = new JFrame("Presentation overview");
        mainFrame.setSize(1500, 1500);
        mainFrame.getContentPane().setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //FRAME: PRESENTATIE TOEVOEGEN
        ptFrame = new JFrame("Presentatie toevoegen");
        ptFrame.setSize(500, 500);
        ptFrame.getContentPane().setLayout(new BorderLayout());
        ptFrame.getContentPane().add(new PanelPresentatieToevoegen(), BorderLayout.CENTER);
        ptFrame.pack();
        ptFrame.setVisible(false);       
        
        //presentatie overview pannel aanmaken
        initTimeTable();
 
        //display the window
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
    private void initTimeTable() 
    {        
        TimeBarModel model = ModelCreator.createCalendarModel();;
        _tbv = new TimeBarViewer(model);

        _tbv.addIntervalModificator(new DefaultIntervalModificator());

        _tbv.setPixelPerSecond(0.018);
        _tbv.setDrawRowGrid(true);

        _tbv.setSelectionDelta(6);
        // this is the col width!
        _tbv.setRowHeight(150);
        
        _tbv.setTBOrientation(TimeBarViewerInterface.Orientation.VERTICAL);
        // vertical: the y axiswidth is the height of the row headers!
        _tbv.setYAxisWidth(50);
        
        // do not adjust the displayed time according to the model 
        // use the basedate day!
        _tbv.setAdjustMinMaxDatesByModel(false);
        _tbv.setMinDate(CalendarModel.BASEDATE.copy());
        _tbv.setMaxDate(CalendarModel.BASEDATE.copy().advanceDays(1));

        _tbv.setDrawOverlapping(true);
        _tbv.setSelectionDelta(6);
        _tbv.setTimeScalePosition(TimeBarViewerInterface.TIMESCALE_POSITION_TOP);

        // modifications are restricted
        _tbv.addIntervalModificator(new PresentationModificator());

        _tbv.setTimeScaleRenderer(new OldDefaultTimeScaleRenderer());
        
        _tbv.setGridRenderer(new CalendarGridRenderer());
        
        _tbv.registerTimeBarRenderer(Presentation.class, new PresentationRenderer());
        _tbv.setAutoScaleRows(5);
        _tbv.setOptimizeScrolling(true);
         
        mainFrame.getContentPane().add(_tbv, BorderLayout.CENTER);

        mainFrame.getContentPane().add(new CalendarSortPanel(), BorderLayout.EAST);
        
        JButton voegPresentatieToe = new JButton("Voeg presentatie toe");
        voegPresentatieToe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ptFrame.setVisible(true);
            }
        });
        mainFrame.getContentPane().add(voegPresentatieToe, BorderLayout.SOUTH);
        
        //mainFrame.getContentPane().add(new CalendarControlPanel(_tbv), BorderLayout.SOUTH);
        
        mainFrame.setVisible(true);

    }
}