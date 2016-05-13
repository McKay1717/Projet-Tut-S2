/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package gui;

// Start of user code (user defined imports)
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// End of user code

import engine.GrilleJeux;

public class CaseListener_Initialisation implements ActionListener
{
	// Start of user code (user defined attributes for CaseListener)
	public AccueilJFrame fenetre;
	public GrilleJeux grille_jeu;
	// End of user code

	/**
	 * The constructor.
	 */
	public CaseListener_Initialisation(GrilleJeux grille_jeu, AccueilJFrame fenetre)
	{
		this.grille_jeu = grille_jeu;
		this.fenetre = fenetre;
		//fenetre.grilleDeJeuJPanel.setControlBouton(this);
	}

	// Start of user code (user defined methods for CaseListener)

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		
	}

	// End of user code
}