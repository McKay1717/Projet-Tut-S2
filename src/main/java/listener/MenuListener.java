package listener;

import gui.MenuSuperieurJMenuBar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Tanguy on 04/06/2016.
 */
public class MenuListener implements ActionListener{
    MenuSuperieurJMenuBar menuSuperieurJMenuBar;

    public MenuListener(){};
    public MenuListener(MenuSuperieurJMenuBar menuSuperieurJMenuBar){
        this.menuSuperieurJMenuBar=menuSuperieurJMenuBar;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if ( e.getSource() == menuSuperieurJMenuBar.getItemInfo1()){
            menuSuperieurJMenuBar.getMessage().showMessageDialog( menuSuperieurJMenuBar.getMessage(),menuSuperieurJMenuBar.getSignature(), "Information",  JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
