package listener;

import static gui.GrilleDeJeuJPanel.TAILLE_GRILLE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import engine.Case;
import engine.GrilleJeux;
import gui.AccueilJFrame;
import gui.BateauJButton;
import gui.GrilleDeJeuJPanel;

public class JeuListener implements ActionListener
{
	public JButton[][]	grille;
	public Case[][]		grille_model;

	public JeuListener(AccueilJFrame fenetre, GrilleJeux grilleJeux)
	{
		this.grille = ((GrilleDeJeuJPanel) fenetre.getjPanel()).grille;
		grille_model = grilleJeux.getCases();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		int[] position = case_appelee(e);

		if (!grille_model[position[0]][position[1]].getTouche())
			grille_model[position[0]][position[1]].setTouche(true);
		
		if (grille[position[0]][position[1]] instanceof BateauJButton)
		{
			
		}
	}

	private int[] case_appelee(ActionEvent e)
	{
		int[] position = new int[2];

		for (int i = 0 ; i < TAILLE_GRILLE ; i++)
			for (int j = 0 ; j < TAILLE_GRILLE ; j++)
				if (e.getSource().equals(grille[i][j]))
				{
					position[0] = i;
					position[1] = j;
				}

		return position;
	}
}