/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Description of SelectionBateauJPanel.
 * 
 * @author nicolas
 */
public class SelectionBateauJPanel extends JPanel {
	// Start of user code (user defined attributes for SelectionBateauJPanel)
	public BateauJButton PorteAvion,Croiseur,ContretTorpilleur,Torpilleur,SousMarin;
	// End of user code


	private static final long serialVersionUID = 3937304672276095355L;


	public SelectionBateauJPanel() {
		// Start of user code constructor for SelectionBateauJPanel)
		super();
		initPanel();
		createPanel();
		// End of user code
	}
	// Start of user code (user defined methods for SelectionBateauJPanel)
	private void initPanel() {
		PorteAvion = new BateauJButton("Porte Avion X1");
		PorteAvion.estPorteAvion();

		Croiseur = new BateauJButton("Croiseur X1");
		Croiseur.estCroiseur();

		ContretTorpilleur = new BateauJButton("Contret Torpilleur X1");
		ContretTorpilleur.estContretTorpilleur();

		Torpilleur = new BateauJButton("Torpilleur X2");
		Torpilleur.estTorpilleur();

		SousMarin = new BateauJButton("Sous Marin X1");
		SousMarin.estSousMarin();

	}

	private void createPanel() {
		add(PorteAvion);
		add(Croiseur);
		add(ContretTorpilleur);
		add(Torpilleur);
		add(SousMarin);
		setLayout(new GridLayout(5,1));
	}

	// End of user code

}
