package gui;

import static gui.GrilleDeJeuJPanel.TAILLE_GRILLE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class JeuListener implements ActionListener
{
	public JButton[][] grille;

	public JeuListener(AccueilJFrame fenetre)
	{
		this.grille = ((GrilleDeJeuJPanel) fenetre.jPanel).grille;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		int[] position = case_appelee(e);

		if (e.getSource() instanceof BateauJButton)
		{
			//Il manque les méthodes pour toucher les bateaux !
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