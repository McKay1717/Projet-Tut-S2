/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package listener;

import static gui.GrilleDeJeuJPanel.TAILLE_GRILLE;
import static java.awt.Color.BLUE;
import static java.awt.Color.RED;
import static java.lang.Math.min;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import engine.Equipe;
import engine.GrilleJeux;
import gui.AccueilJFrame;
import gui.ArrierePlanJPanel;
import gui.BateauJButton;
import gui.CaseJButton;
import gui.GrilleDeJeuJPanel;

// Start of user code (user defined imports)
// End of user code

public class CaseListener_Initialisation implements ActionListener
{
	// Start of user code (user defined attributes for CaseListener)
	public AccueilJFrame				fenetre;
	public GrilleJeux					grille_jeu;
	public Equipe						equipe;
	public JButton[][]					grille;
	public BateauJButton[]				bateauJButton;
	public ArrayList<BateauJButton[]>	bateauJButtons;
	public int[][]						position_save;
	// End of user code

	/**
	 * The constructor.
	 */
	public CaseListener_Initialisation(GrilleJeux grille_jeu, AccueilJFrame fenetre)
	{
		this.grille_jeu = grille_jeu;
		this.fenetre = fenetre;
		grille = ((ArrierePlanJPanel) fenetre.getjPanel()).getGrilleDeJeuJPanel().grille;
		bateauJButton = null;
		position_save = null;
	}

	// Start of user code (user defined methods for CaseListener)

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() instanceof CaseJButton && bateauJButton != null)
		{
			if (position_save == null)
			{
				case_appelee(e, 0);
				cases_possibles();
			}
			else
			{
				case_appelee(e, 1);
				place_bateau();
				position_save = null;
				bateauJButton = null;
				reset_color();
			}
		}
		else if (e.getSource() instanceof BateauJButton)
			setBateau(e);
	}

	private void case_appelee(ActionEvent e, int numero_case)
	{
		position_save = new int[2][2];
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

		if (position_save[0][1] + bateauJButton.length - 1 > TAILLE_GRILLE)
			grille[position_save[0][0]][position_save[0][1] + bateauJButton.length - 1].setBackground(RED);
	}

	private void place_bateau()
	{
		// if (equipe.setPlacement(position_save[0][0], position_save[0][1],
		// position_save[1][0], position_save[1][1], bateauJButton.length))
		if (grille[position_save[1][0]][position_save[1][1]].getBackground().equals(RED))
			for (int i = min(position_save[0][0], position_save[1][0]) , j = min(position_save[0][1],
					position_save[1][0]) , k = 0 ; i < min(position_save[0][0], position_save[1][0])
							+ bateauJButton.length
							&& j < min(position_save[0][1], position_save[1][0])
									+ bateauJButton.length ; i++ , j++ , k++)
				grille[i][j] = bateauJButton[k];
	}

	private void reset_color()
	{
		for (int i = 0 ; i < grille.length ; i++)
			for (int j = 0 ; j < grille.length ; j++)
				if (grille[i][j] instanceof CaseJButton)
					grille[i][j].setBackground(BLUE);
	}

	private void setBateau(ActionEvent e)
	{
		boolean stop = false;
		for (int i = 0 ; i < bateauJButtons.size() && !stop ; i++)
			for (int j = 0 ; j < bateauJButtons.get(i).length && !stop ; j++)
				if (e.getSource().equals(bateauJButtons.get(i)[j]))
				{
					bateauJButton = new BateauJButton[bateauJButtons.get(i).length];
					for (int k = 0 ; k < bateauJButtons.get(i).length ; k++)
						bateauJButton[k] = bateauJButtons.get(i)[k];
					stop = true;
				}
	}
	// End of user code
}