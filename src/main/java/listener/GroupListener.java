/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package listener;

import engine.Equipe;
import engine.GrilleJeux;
import gui.AccueilJFrame;
import gui.ArrierePlanJPanel;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

public class GroupListener
{
	// Start of user code (user defined attributes for GrilleDeJeuJPanel)
	public GrilleJeux					grille_jeux1, grille_jeux2;
	//public GrilleDeJeuJPanel			grilleDeJeuJPanel1, grilleDeJeuJPanel2;
	public ArrierePlanJPanel			arrierePlanJPanel1, arrierePlanJPanel2;
	public Equipe						equipe1, equipe2;
	public AccueilJFrame				fenetre;
	public CaseListener_Initialisation	caseListener1, caseListener2;
	// End of user code

	/**
	 * The constructor.
	 */
	public GroupListener(GrilleJeux grille_jeux1, GrilleJeux grille_jeux2, Equipe equipe1, Equipe equipe2)
	{
		this.grille_jeux1 = grille_jeux1;
		this.grille_jeux2 = grille_jeux2;
		this.equipe1 = equipe1;
		this.equipe2 = equipe2;

		fenetre = new AccueilJFrame(this);
		fenetre.setVisible(true);
	}

	public void createGrilleDeJeuJPanel(int i)
	{
		fenetre.setVisible(false);
		fenetre.getContentPane().removeAll();
		if (i == 1)
		{
			showMessageDialog(null, equipe1.getNomEquipe() + ", veuillez placer vos bateaux", "Initialisation",
					INFORMATION_MESSAGE);
			//grilleDeJeuJPanel1 = new GrilleDeJeuJPanel(grille_jeux1);
			arrierePlanJPanel1 = new ArrierePlanJPanel(grille_jeux1);
			fenetre.setjPanel(arrierePlanJPanel1);
			//caseListener1 = new CaseListener_Initialisation(grille_jeux1, fenetre);
			arrierePlanJPanel1.getGrilleDeJeuJPanel().setCaseListener(caseListener1);
		}
		else
		{
			showMessageDialog(null, equipe2.getNomEquipe() + ", veuillez placer vos bateaux", "Initialisation",
					INFORMATION_MESSAGE);
			//grilleDeJeuJPanel2 = new GrilleDeJeuJPanel(grille_jeux2);
			arrierePlanJPanel2 = new ArrierePlanJPanel(grille_jeux2);
			fenetre.setjPanel(arrierePlanJPanel2);
			//caseListener2 = new CaseListener_Initialisation(grille_jeux2, fenetre);
			arrierePlanJPanel2.getGrilleDeJeuJPanel().setCaseListener(caseListener2);
		}
		fenetre.pack();
		fenetre.setLocationRelativeTo(null);
		fenetre.getContentPane().repaint();
		fenetre.setVisible(true);
	}
}