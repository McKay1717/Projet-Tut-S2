package listener;

import gui.AccueilJPanel;
import gui.TestJMenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import engine.Equipe;
import engine.GrilleJeux;

/**
 * Created by victor on 26/05/16.
 */
public class FprincListener implements ActionListener {

	private AccueilJPanel accueilJPanel;

	public FprincListener(AccueilJPanel accueilJPane) {
		this.accueilJPanel = accueilJPane;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource().equals(AccueilJPanel.getbPLay())) {
			accueilJPanel.close();
			initGame();
			// EventMenu eventMenu = new EventMenu(pict,f,FPrincipale);
		}

		if (actionEvent.getSource().equals(AccueilJPanel.getbQuit())) {
			System.exit(0);
		}
	}

	public Equipe[] initGame() {

		// On Crée les Objets que l'on à besoins
		GrilleJeux gj1 = new GrilleJeux();

		GrilleJeux gj2 = new GrilleJeux();

		Equipe equipes1 = new Equipe(gj1, "");
		Equipe equipes2 = new Equipe(gj2, "");

		Equipe[] equipes = new Equipe[] { equipes1, equipes2 };
		// On créer le liens entre equipes et grille
		gj1.setEquipes(equipes);
		gj2.setEquipes(equipes);

		String equipe1 = JOptionPane.showInputDialog(null, "nom du Joueur 1 ?", "", JOptionPane.QUESTION_MESSAGE);
		equipes1.setNomEquipe(equipe1);
		
		String equipe2 = JOptionPane.showInputDialog(null, "nom du Joueur 2 ?", "", JOptionPane.QUESTION_MESSAGE);
		equipes2.setNomEquipe(equipe2);
		return equipes;
	}
}
