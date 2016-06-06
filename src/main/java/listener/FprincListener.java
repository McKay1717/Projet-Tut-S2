package listener;

import gui.AccueilJPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by victor on 26/05/16.
 */
public class FprincListener implements ActionListener
{

	private AccueilJPanel accueilJPanel;

	public FprincListener(AccueilJPanel accueilJPane)
	{
		this.accueilJPanel = accueilJPane;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent)
	{
		if (actionEvent.getSource().equals(AccueilJPanel.getbPLay()))
		{
			accueilJPanel.close();
			initGame();
			accueilJPanel.accueilJFrame.groupListener.createGrilleDeJeuJPanel(1);
		}

		if (actionEvent.getSource().equals(AccueilJPanel.getbQuit()))
			System.exit(0);
	}

	public void initGame()
	{
		if(accueilJPanel.accueilJFrame.groupListener.equipe1.getNomEquipe().length()==0){
			String equipe1 = JOptionPane.showInputDialog(null, "nom du Joueur 1 ?", "", JOptionPane.QUESTION_MESSAGE);
			JOptionPane jop1 = new JOptionPane();
			while (equipe1.length() == 0) {
				jop1.showMessageDialog(null, "Votre non et vide", "error", JOptionPane.INFORMATION_MESSAGE);
				equipe1 = JOptionPane.showInputDialog(null, "nom du Joueur 1 ?", "", JOptionPane.QUESTION_MESSAGE);
			}
			accueilJPanel.accueilJFrame.groupListener.equipe1.setNomEquipe(equipe1);
		}

		if(accueilJPanel.accueilJFrame.groupListener.equipe2.getNomEquipe().length()==0){
			String equipe2 = JOptionPane.showInputDialog(null, "nom du Joueur 2 ?", "", JOptionPane.QUESTION_MESSAGE);
			JOptionPane jop2 = new JOptionPane();
			while (equipe2.length() == 0) {
				jop2.showMessageDialog(null, "Votre non et vide", "error", JOptionPane.INFORMATION_MESSAGE);
				equipe2 = JOptionPane.showInputDialog(null, "nom du Joueur 2 ?", "", JOptionPane.QUESTION_MESSAGE);
			}
			accueilJPanel.accueilJFrame.groupListener.equipe2.setNomEquipe(equipe2);
		}

	}
}