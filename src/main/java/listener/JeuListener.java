package listener;

import static gui.GrilleDeJeuJPanel.TAILLE_GRILLE;
import static java.awt.Color.GRAY;
import static java.awt.Color.ORANGE;
import static java.awt.Color.RED;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import engine.Case;
import engine.GrilleJeux;
import gui.BateauJButton;
import gui.CaseJButton;
import gui.FenetreJeux;

public class JeuListener implements ActionListener
{
	public JButton[][]	grille1, grille2;
	public Case[][]		grille_model1, grille_model2;

	public JeuListener(FenetreJeux fenetre, GrilleJeux grilleJeux1, GrilleJeux grilleJeux2)
	{
		this.grille1 = fenetre.deJeuJPanel1.grille;
		this.grille2 = fenetre.deJeuJPanel2.grille;
		grille_model1 = grilleJeux1.getCases();
		grille_model2 = grilleJeux2.getCases();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Case[][] grille_model_courante = grille_model_courante();
		JButton[][] grille_courante = grille_courante();

		int[] position = case_appelee(e, grille_courante);

		if (!grille_model_courante[position[0]][position[1]].getTouche())
			grille_model_courante[position[0]][position[1]].setTouche(true);

		if (grille_courante[position[0]][position[1]] instanceof CaseJButton)
		{
			// Image d'une case vide touchée.

			grille_courante[position[0]][position[1]].setBackground(GRAY);

		}
		else if (grille_courante[position[0]][position[1]] instanceof BateauJButton)
		{
			if (grille_model_courante[position[0]][position[1]].getTouche())
			{
				// Si le bateau est touché, une image de feu ou autre.
				grille_courante[position[0]][position[1]].setBackground(ORANGE);

			}
			else if (grille_model_courante[position[0]][position[1]].getBateau().getEstCoule())
			{
				// Si le bateau est coulé, apparition du bateau coulé à l'écran.
				grille_courante[position[0]][position[1]].setBackground(RED);
			}
		}

		// Passage à la seconde grille.
	}

	private int[] case_appelee(ActionEvent e, JButton[][] grille_courante)
	{
		int[] position = new int[2];

		for (int i = 0 ; i < TAILLE_GRILLE ; i++)
			for (int j = 0 ; j < TAILLE_GRILLE ; j++)
				if (e.getSource().equals(grille_courante[i][j]))
				{
					position[0] = i;
					position[1] = j;
				}

		return position;
	}

	private Case[][] grille_model_courante()
	{
		return grille_model1;
	}

	private JButton[][] grille_courante()
	{
		return grille1;
	}
}