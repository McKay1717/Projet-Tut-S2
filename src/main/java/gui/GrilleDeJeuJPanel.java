/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package gui;

// Start of user code (user defined imports)
import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.GrilleJeux;
// End of user code

/**
 * Description of GrilleDeJeuJPanel.
 * 
 * @author nicolas
 */
public class GrilleDeJeuJPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -416871502500554822L;
	public static final int TAILLE_GRILLE = 10;															//Taille des lignes et colonnes de la grille.
	public static final char[] INTITULE_LIGNE = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};		//Intitulé des lignes.

	// Start of user code (user defined attributes for GrilleDeJeuJPanel)
	public CaseJButton[][] grille;		//Grille de JButton.
	public JLabel[] intitule_ligne;		//Intitulé des lignes.
	public JLabel[] intitule_colonne;	//Intitulé des colonnes.
	public CaseListener control_button;	//Contrôleur de bouton.

	public GrilleJeux grille_jeu;		//Grille de jeux — moteur.
	// End of user code

	/**
	 * The constructor.
	 */
	public GrilleDeJeuJPanel()
	{
		// Start of user code constructor for GrilleDeJeuJPanel)
		control_button = new CaseListener(this);	//Initialisation du contrôleur de bouton.
		initAttribut();								//Initialisation des attributs.
		creerWidget();								//Initialisation de la fenêtre.
		// End of user code
	}

	// Start of user code (user defined methods for GrilleDeJeuJPanel)

	/**
	 * Initialisation de la grille.
	 */
	public void initAttribut()
	{
		grille_jeu = new GrilleJeux();								//Initialisation de la grille.
		grille = new CaseJButton[TAILLE_GRILLE][TAILLE_GRILLE];		//Initialisation du tableau de CaseJButton.

		//Parcours de la grille pour initialiser chaque case.
		for (int i = 0 ; i < TAILLE_GRILLE ; i++)
			for (int j = 0 ; j < TAILLE_GRILLE ; j++)
				grille[i][j] = new CaseJButton(grille_jeu, i, j);

		//Initialisation de l'intitulé des lignes.
		for (int i = 0 ; i < TAILLE_GRILLE ; i++)
			intitule_ligne[i] = new JLabel(Character.toString(INTITULE_LIGNE[i]));

		//Initialisation de l'intitulé des colonnes.
		for (int i = 0 ; i < TAILLE_GRILLE ; i++)
			intitule_colonne = new JLabel(Integer.toString(i + 1));
	}

	/**
	 * Création de la fenêtre.
	 */
	public void creerWidget()
	{
		JPanel pGrille = new JPanel(new GridLayout(TAILLE_GRILLE + 1, TAILLE_GRILLE + 1));
		for (int i = 0 ; i < TAILLE_GRILLE + 1 ; i++)
			for (int j = 0 ; j < TAILLE_GRILLE + 1 ; j++)
			{
				if (i == 0 && j != 0)
					pGrille.add(intitule_colonne[j - 1]);
				else if (i != 0 && j == 0)
					pGrille.add(intitule_ligne[i - 1]);
				else if (i != 0 && j != 0)
					pGrille.add(grille[i - 1][j - 1]);
			}
	}

	// End of user code
}