/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package gui;

import engine.GrilleJeux;

public class GroupListener
{
	// Start of user code (user defined attributes for GrilleDeJeuJPanel)
	public GrilleJeux grille_jeu;
	public AccueilJFrame fenetre;
	public CaseListener caseListener;
	// End of user code

	/**
	 * The constructor.
	 */
	public GroupListener(GrilleJeux grille_jeu)
	{
		this.grille_jeu = grille_jeu;
		//fenetre = new AcceuilJFrame(this.grille_jeu);
		caseListener = new CaseListener(grille_jeu, fenetre);
		//fenetre.affiche();
	}
}