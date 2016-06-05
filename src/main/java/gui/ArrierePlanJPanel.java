/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

import engine.GrilleJeux;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of ArrierePlanJPanel.
 * 
 * @author nicolas
 */

public class ArrierePlanJPanel extends JPanel
{

	private static final long		serialVersionUID	= -553855920680431324L;

	private GrilleJeux				grille_jeux;

	private GrilleDeJeuJPanel		grilleDeJeuJPanel;
	private SelectionBateauJPanel	selectionBateauJPanel;

	public ArrierePlanJPanel(GrilleJeux grille_jeux)
	{
		// Start of user code constructor for ArrierePlanJPanel)
		// super();
		super(new GridLayout(1, 1));

		this.grille_jeux = grille_jeux;

		grilleDeJeuJPanel = new GrilleDeJeuJPanel(grille_jeux);
		selectionBateauJPanel = new SelectionBateauJPanel(grille_jeux);

		creerWidget();

		// End of user code
	}

	public void creerWidget()
	{
		// disposition des panels
		Container contp = new Container();
		contp.setLayout(new GridBagLayout());
		GridBagConstraints gbd = new GridBagConstraints();
		gbd.ipadx = 20;
		gbd.ipady = 20;
		contp.add(grilleDeJeuJPanel, gbd);
		contp.add(selectionBateauJPanel, gbd);

		add(contp);

		/*
		 * add(grilleDeJeuJPanel); add(selectionBateauJPanel,
		 * BorderLayout.EAST);
		 */
	}

	public SelectionBateauJPanel getSelectionBateauJPanel()
	{
		return selectionBateauJPanel;
	}

	public GrilleDeJeuJPanel getGrilleDeJeuJPanel()
	{
		return grilleDeJeuJPanel;
	}
}
