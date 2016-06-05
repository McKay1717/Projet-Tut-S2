/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package gui;

import engine.GrilleJeux;

import javax.swing.*;
import java.awt.*;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of ArrierePlanJPanel.
 * 
 * @author nicolas
 */

public class ArrierePlanJPanel extends JPanel {

	private static final long serialVersionUID = -553855920680431324L;


	private GrilleJeux grille_jeux;


	private GrilleDeJeuJPanel grilleDeJeuJPanel;
	private SelectionBateauJPanel selectionBateauJPanel;

	public ArrierePlanJPanel(GrilleJeux grille_jeux) {
		// Start of user code constructor for ArrierePlanJPanel)
		//super();
		super(new GridLayout(1, 2));

		this.grille_jeux= grille_jeux;


		creerWidget(grille_jeux); // Initialisation des attributs .

		// End of user code
	}


	private void creerWidget(GrilleJeux grille_jeux) {

		grilleDeJeuJPanel = new GrilleDeJeuJPanel(grille_jeux);
		selectionBateauJPanel = new SelectionBateauJPanel(grille_jeux);

		add(grilleDeJeuJPanel);
		add(selectionBateauJPanel);
	}

	public SelectionBateauJPanel getSelectionBateauJPanel() {
		return selectionBateauJPanel;
	}
}
