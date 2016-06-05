package listener;

import gui.AccueilJFrame;
import gui.AccueilJPanel;
import gui.MenuSuperieurJMenuBar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Tanguy on 04/06/2016.
 */
public class MenuListener implements ActionListener{
    MenuSuperieurJMenuBar menuSuperieurJMenuBar;
    AccueilJFrame accueilJFrame;
    AccueilJPanel accueilJPanel;

    public MenuListener(){};
    public MenuListener(MenuSuperieurJMenuBar menuSuperieurJMenuBar, AccueilJFrame accueilJFrame){
        this.menuSuperieurJMenuBar=menuSuperieurJMenuBar;
        this.accueilJFrame=accueilJFrame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if ( e.getSource() == menuSuperieurJMenuBar.getItemInfo1()){
            menuSuperieurJMenuBar.getMessage().showMessageDialog( menuSuperieurJMenuBar.getMessage(),menuSuperieurJMenuBar.getSignature(), "Information",  JOptionPane.INFORMATION_MESSAGE);
        }
        if ( e.getSource() == menuSuperieurJMenuBar.getItemOptionPlay1()){
            accueilJPanel = new AccueilJPanel(this.accueilJFrame);
            accueilJFrame.setSize(400, 250);
            accueilJFrame.setjPanel(accueilJPanel);
            menuSuperieurJMenuBar.setAccueilJPanel(accueilJPanel);
            accueilJFrame.setLocationRelativeTo(null);

            accueilJFrame.getContentPane().repaint();
            MenuSuperieurJMenuBar menuBar = new MenuSuperieurJMenuBar(this.accueilJFrame);
            accueilJFrame.setJMenuBar(menuBar);
            accueilJFrame.setVisible(true);

        }
    }
}
