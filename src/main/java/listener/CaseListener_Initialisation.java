/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package listener;

import static gui.GrilleDeJeuJPanel.TAILLE_GRILLE;
import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;
import static java.awt.Color.ORANGE;
import static java.awt.Color.PINK;
import static java.awt.Color.RED;

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
				position_save = new int[2][2];
				case_appelee(e, 0);
				cases_possibles();
			}
			else if (((CaseJButton) e.getSource()).getBackground().equals(RED))
			{
				case_appelee(e, 1);
				place_bateau();
				reset_color(true);
				position_save = null;
				bateauJButton = null;
			}
			else
			{
				reset_color(false);
				position_save = null;
				bateauJButton = null;
			}
		}
		else if (e.getSource() instanceof BateauJButton)
			setBateau(e);
	}

	private void case_appelee(ActionEvent e, int numero_case)
	{
		for (int i = 0 ; i < TAILLE_GRILLE ; i++)
			for (int j = 0 ; j < TAILLE_GRILLE ; j++)
				if (e.getSource().equals(grille[i][j]))
				{
					position_save[numero_case][0] = i;
					position_save[numero_case][1] = j;
				}
	}

	private void cases_possibles()
	{
		if (position_save[0][0] - bateauJButton.length + 1 >= 0)
		{
			for (int i = position_save[0][0] - bateauJButton.length + 1 ; i <= position_save[0][0] ; i++)
				grille[i][position_save[0][1]].setBackground(ORANGE);
			grille[position_save[0][0] - bateauJButton.length + 1][position_save[0][1]].setBackground(RED);
		}

		if (position_save[0][0] + bateauJButton.length - 1 < TAILLE_GRILLE)
		{
			for (int i = position_save[0][0] ; i <= position_save[0][0] + bateauJButton.length - 1 ; i++)
				grille[i][position_save[0][1]].setBackground(ORANGE);
			grille[position_save[0][0] + bateauJButton.length - 1][position_save[0][1]].setBackground(RED);
		}

		if (position_save[0][1] - bateauJButton.length + 1 >= 0)
		{
			for (int i = position_save[0][1] - bateauJButton.length + 1 ; i <= position_save[0][1] ; i++)
				grille[position_save[0][0]][i].setBackground(ORANGE);
			grille[position_save[0][0]][position_save[0][1] - bateauJButton.length + 1].setBackground(RED);
		}

		if (position_save[0][1] + bateauJButton.length - 1 < TAILLE_GRILLE)
		{
			for (int i = position_save[0][1] ; i <= position_save[0][1] + bateauJButton.length - 1 ; i++)
				grille[position_save[0][0]][i].setBackground(ORANGE);
			grille[position_save[0][0]][position_save[0][1] + bateauJButton.length - 1].setBackground(RED);
		}

		grille[position_save[0][0]][position_save[0][1]].setBackground(PINK);
	}

	private void place_bateau()
	{
		if (position_save[1][0] - bateauJButton.length + 1 == position_save[0][0])
		{
			for (int i = position_save[0][0] , j = 0 ; i <= position_save[1][0] ; i++ , j++)
			{
				grille[i][position_save[1][1]] = new BateauJButton();
				switch (bateauJButton[j].typeBateau)
				{
					case "Porte-avion":
						((BateauJButton) grille[i][position_save[1][1]]).estPorteAvion();
						break;
					case "Croiseur":
						((BateauJButton) grille[i][position_save[1][1]]).estCroiseur();
						break;
					case "Contre-Torpilleur":
						((BateauJButton) grille[i][position_save[1][1]]).estContretTorpilleur();
						break;
					case "Torpilleur":
						((BateauJButton) grille[i][position_save[1][1]]).estTorpilleur();
						break;
					case "Sous-marin":
						((BateauJButton) grille[i][position_save[1][1]]).estSousMarin();
						break;
				}
			}
		}
		else if (position_save[1][0] + bateauJButton.length - 1 == position_save[0][0])
			for (int i = position_save[1][0] , j = 0 ; i <= position_save[0][0] ; i++ , j++)
			{
				grille[i][position_save[1][1]] = new BateauJButton();
				switch (bateauJButton[j].typeBateau)
				{
					case "Porte-avion":
						((BateauJButton) grille[i][position_save[1][1]]).estPorteAvion();
						break;
					case "Croiseur":
						((BateauJButton) grille[i][position_save[1][1]]).estCroiseur();
						break;
					case "Contre-Torpilleur":
						((BateauJButton) grille[i][position_save[1][1]]).estContretTorpilleur();
						break;
					case "Torpilleur":
						((BateauJButton) grille[i][position_save[1][1]]).estTorpilleur();
						break;
					case "Sous-marin":
						((BateauJButton) grille[i][position_save[1][1]]).estSousMarin();
						break;
				}
			}
		else if (position_save[1][1] - bateauJButton.length + 1 == position_save[0][1])
			for (int i = position_save[0][1] , j = 0 ; i <= position_save[1][1] ; i++ , j++)
			{
				grille[position_save[1][0]][i] = new BateauJButton();
				switch (bateauJButton[j].typeBateau)
				{
					case "Porte-avion":
						((BateauJButton) grille[position_save[1][0]][i]).estPorteAvion();
						break;
					case "Croiseur":
						((BateauJButton) grille[position_save[1][0]][i]).estCroiseur();
						break;
					case "Contre-Torpilleur":
						((BateauJButton) grille[position_save[1][0]][i]).estContretTorpilleur();
						break;
					case "Torpilleur":
						((BateauJButton) grille[position_save[1][0]][i]).estTorpilleur();
						break;
					case "Sous-marin":
						((BateauJButton) grille[position_save[1][0]][i]).estSousMarin();
						break;
				}
			}
		else if (position_save[1][1] + bateauJButton.length - 1 == position_save[0][1])
			for (int i = position_save[1][1] , j = 0 ; i <= position_save[0][1] ; i++ , j++)
			{
				grille[position_save[1][0]][i] = new BateauJButton();
				switch (bateauJButton[j].typeBateau)
				{
					case "Porte-avion":
						((BateauJButton) grille[position_save[1][0]][i]).estPorteAvion();
						break;
					case "Croiseur":
						((BateauJButton) grille[position_save[1][0]][i]).estCroiseur();
						break;
					case "Contre-Torpilleur":
						((BateauJButton) grille[position_save[1][0]][i]).estContretTorpilleur();
						break;
					case "Torpilleur":
						((BateauJButton) grille[position_save[1][0]][i]).estTorpilleur();
						break;
					case "Sous-marin":
						((BateauJButton) grille[position_save[1][0]][i]).estSousMarin();
						break;
				}
			}
	}

	private void reset_color(boolean bateau_place)
	{
		for (int i = 0 ; i < bateauJButton.length ; i++)
		{
			if (bateau_place)
				bateauJButton[i].setBackground(RED);
			else
				bateauJButton[i].setBackground(BLACK);
		}

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
					{
						bateauJButton[k] = bateauJButtons.get(i)[k];
						bateauJButton[k].setBackground(ORANGE);
					}
					stop = true;
				}
	}
	// End of user code
}