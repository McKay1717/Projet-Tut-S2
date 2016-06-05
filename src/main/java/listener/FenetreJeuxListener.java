package listener;

import gui.FenetreJeux;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by victor on 05/06/16.
 */
public class FenetreJeuxListener implements ActionListener {

    private FenetreJeux fenetreJeux;

    public FenetreJeuxListener(FenetreJeux fenetreJeux) {
        this.fenetreJeux = fenetreJeux;

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    public FenetreJeux getFenetreJeux() {
        return fenetreJeux;
    }
}
