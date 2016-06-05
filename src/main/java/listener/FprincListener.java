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
		String equipe1 = JOptionPane.showInputDialog(null, "nom du Joueur 1 ?", "", JOptionPane.QUESTION_MESSAGE);
		accueilJPanel.accueilJFrame.groupListener.equipe1.setNomEquipe(equipe1);

		String equipe2 = JOptionPane.showInputDialog(null, "nom du Joueur 2 ?", "", JOptionPane.QUESTION_MESSAGE);
		accueilJPanel.accueilJFrame.groupListener.equipe2.setNomEquipe(equipe2);
	}
}