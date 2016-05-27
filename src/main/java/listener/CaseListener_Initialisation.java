/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package listener;

import static gui.GrilleDeJeuJPanel.TAILLE_GRILLE;
import static java.awt.Color.RED;
import static java.lang.Math.max;
import static java.lang.Math.min;

// Start of user code (user defined imports)
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// End of user code

import javax.swing.JButton;

import engine.Equipe;
import engine.GrilleJeux;
import gui.AccueilJFrame;
import gui.BateauJButton;
import gui.CaseJButton;
import gui.GrilleDeJeuJPanel;

public class CaseListener_Initialisation implements ActionListener
{
	// Start of user code (user defined attributes for CaseListener)
	public AccueilJFrame	fenetre;
	public GrilleJeux		grille_jeu;
	public Equipe			equipe;
	public JButton[][]		grille;
	public BateauJButton[]	bateauJButton;
	public int[][]			position_save;
	// End of user code

	/**
	 * The constructor.
	 */
	public CaseListener_Initialisation(GrilleJeux grille_jeu, AccueilJFrame fenetre)
	{
		this.grille_jeu = grille_jeu;
		this.fenetre = fenetre;
		grille = ((GrilleDeJeuJPanel) fenetre.getjPanel()).grille;
		bateauJButton = null;
		position_save = null;
		// fenetre.grilleDeJeuJPanel.setControlBouton(this);
	}

	// Start of user code (user defined methods for CaseListener)

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() instanceof CaseJButton)
		{
			if (position_save.equals(null))
			{
				position_save = new int[2][2];
				case_appelee(e, 0);
				cases_possibles();
			}
			else
			{
				case_appelee(e, 1);
				place_bateau();
				position_save = null;
				bateauJButton = null;
			}
		}
		else if (e.getSource() instanceof BateauJButton)
			bateauJButton = (BateauJButton[]) e.getSource();
	}

	private void case_appelee(ActionEvent e, int numero_case)
	{
		for (int i = 0 ; i < TAILLE_GRILLE ; i++)
			for (int j = 0 ; j < TAILLE_GRILLE ; j++)
				if (e.getSource().equals(((GrilleDeJeuJPanel) fenetre.getjPanel()).grille[i][j]))
				{
					position_save[numero_case][0] = i;
					position_save[numero_case][1] = j;
				}
	}

	private void cases_possibles()
	{
		if (position_save[0][0] - bateauJButton.length + 1 >= 0)
			grille[position_save[0][0] - bateauJButton.length + 1][position_save[0][1]].setBackground(RED);

		if (position_save[0][0] + bateauJButton.length - 1 < TAILLE_GRILLE)
			grille[position_save[0][0] + bateauJButton.length - 1][position_save[0][1]].setBackground(RED);

		if (position_save[0][1] - bateauJButton.length + 1 >= 0)
			grille[position_save[0][0]][position_save[0][1] - bateauJButton.length + 1].setBackground(RED);

		if (position_save[0][1] + bateauJButton.length - 1 >= TAILLE_GRILLE)
			grille[position_save[0][0]][position_save[0][1] + bateauJButton.length - 1].setBackground(RED);
	}

	private void place_bateau()
	{
		// if (equipe.setPlacement(position_save[0][0], position_save[0][1],
		// position_save[1][0], position_save[1][1], bateauJButton.length))
		if (position_save[0][0] == position_save[1][0])
			for (int i = min(position_save[0][1], position_save[1][1]) , j = 0 ; i < max(position_save[0][1],
					position_save[1][1]) ; i++ , j++)
				grille[position_save[0][0]][i] = bateauJButton[j];
	}
	// End of user code
}