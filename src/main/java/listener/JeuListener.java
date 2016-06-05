package listener;

import static gui.GrilleDeJeuJPanel.TAILLE_GRILLE;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import engine.Case;
import engine.GrilleJeux;
import gui.BateauJButton;
import gui.CaseJButton;
import gui.FenetreJeux;
import gui.GrilleDeJeuJPanel;

public class JeuListener implements ActionListener
{
	public JButton[][]	grille;
	public Case[][]		grille_model1, grille_model2;

	public JeuListener(FenetreJeux fenetre, GrilleJeux grilleJeux1, GrilleJeux grilleJeux2)
	{
		this.grille = ((GrilleDeJeuJPanel) fenetre.getjPanel()).grille;
		grille_model1 = grilleJeux1.getCases();
		grille_model2 = grilleJeux2.getCases();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		int[] position = case_appelee(e);

		if (!grille_model[position[0]][position[1]].getTouche())
			grille_model[position[0]][position[1]].setTouche(true);

		if (grille[position[0]][position[1]] instanceof CaseJButton)
		{
			// Image d'une case vide touchée.

			grille[position[0]][position[1]].setBackground(Color.GRAY);

		}
		else if (grille[position[0]][position[1]] instanceof BateauJButton)
		{
			if (grille_model[position[0]][position[1]].getTouche())
			{
				// Si le bateau est touché, une image de feu ou autre.
				grille[position[0]][position[1]].setBackground(Color.ORANGE);

			}
			else if (grille_model[position[0]][position[1]].getBateau().getEstCoule())
			{
				// Si le bateau est coulé, apparition du bateau coulé à l'écran.
				grille[position[0]][position[1]].setBackground(Color.RED);
			}
		}

		// Passage à la seconde grille.
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