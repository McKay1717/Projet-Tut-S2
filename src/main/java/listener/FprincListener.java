package listener;

import gui.AccueilJPanel;
import gui.TestJMenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by victor on 26/05/16.
 */
public class FprincListener implements ActionListener {

    private AccueilJPanel accueilJFrame;

    public FprincListener( AccueilJPanel accueilJPane) {
        this.accueilJFrame = accueilJPane;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(AccueilJPanel.getbPLay())){
            accueilJFrame.setVisible(false);
            TestJMenuBar menuBar = new TestJMenuBar();
            //FenetreJeu f = new FenetreJeu(pict,menuBar);
            //EventMenu eventMenu = new EventMenu(pict,f,FPrincipale);
        }

        if (actionEvent.getSource().equals(AccueilJPanel.getbQuit())){
            System.exit(0);
        }
    }
}
