/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package gui;

import static gui.GrilleDeJeuJPanel.TAILLE_GRILLE;

// Start of user code (user defined imports)
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// End of user code

import engine.GrilleJeux;

public class CaseListener_Initialisation implements ActionListener
{
	// Start of user code (user defined attributes for CaseListener)
	public AccueilJFrame	fenetre;
	public GrilleJeux		grille_jeu;
	public BateauJButton[]	bateauJButton;
	// End of user code

	/**
	 * The constructor.
	 */
	public CaseListener_Initialisation(GrilleJeux grille_jeu, AccueilJFrame fenetre)
	{
		this.grille_jeu = grille_jeu;
		this.fenetre = fenetre;
		bateauJButton = null;
		// fenetre.grilleDeJeuJPanel.setControlBouton(this);
	}

	// Start of user code (user defined methods for CaseListener)

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() instanceof CaseJButton)
		{
			int[] position = case_appelee(e);
			if (!bateauJButton.equals(null))
				place_bateau(position);
		}
	}

	public int[] case_appelee(ActionEvent e)
	{
		int[] position = new int[2];

		for (int i = 0 ; i < TAILLE_GRILLE ; i++)
			for (int j = 0 ; j < TAILLE_GRILLE ; j++)
				if (e.getSource().equals(((GrilleDeJeuJPanel) fenetre.jPanel).grille[i][j]))
				{
					position[0] = i;
					position[1] = j;
				}

		return position;
	}

	public void place_bateau(int[] position)
	{
		if (position[1] == 0 || position[1] == 1)
			for (int i = 0 ; i < bateauJButton.length ; i++)
				((GrilleDeJeuJPanel) fenetre.jPanel).grille[position[0]][i] = bateauJButton[i];
		else if (position[1] == TAILLE_GRILLE - 2 || position[1] == TAILLE_GRILLE - 1)
			for (int i = TAILLE_GRILLE - bateauJButton.length , j = 0 ; i < TAILLE_GRILLE ; i++ , j++)
				((GrilleDeJeuJPanel) fenetre.jPanel).grille[position[0]][i] = bateauJButton[j];
		else if (bateauJButton.length % 2 != 0)
			for (int i = -bateauJButton.length / 2 , j = 0 ; i <= bateauJButton.length / 2 ; i++ , j++)
				((GrilleDeJeuJPanel) fenetre.jPanel).grille[position[0]][position[1] + i] = bateauJButton[j];
		else
			for (int i = -bateauJButton.length / 2 , j = 0 ; i < bateauJButton.length / 2 ; i++ , j++)
				((GrilleDeJeuJPanel) fenetre.jPanel).grille[position[0]][position[1] + i] = bateauJButton[j];
	}

	// End of user code
}