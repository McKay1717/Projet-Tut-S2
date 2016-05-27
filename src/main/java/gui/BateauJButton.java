/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package gui;

import javax.swing.*;


public class BateauJButton extends JButton{
	// Start of user code (user defined attributes for BateauJButton)
	public String typeBateau;
	public int nbSelection;
	public int taille;
	// End of user code

	private static final long serialVersionUID = 6321877984607297289L;

	public BateauJButton() {
		// Start of user code constructor for BateauJButton)
		super();
		setText(typeBateau);
		// End of user code

	}
	public BateauJButton(String strType) {
		// Start of user code constructor for BateauJButton)
		super(strType);
		//this.setText(typeBateau);
		// End of user code

	}

	public void estPorteAvion() {

		//taille = new PorteAvion().getTaille();

		//futur attribu du bouton
		this.nbSelection = 1;
	}

	public void estCroiseur() {

		//taille = new Croiseur().getTaille();
		//futur attribu du bouton
		this.nbSelection = 1;
	}

	public void estContretTorpilleur() {

		//taille = new ContretTorpilleur().getTaille();
		//futur attribu du bouton
		this.nbSelection = 1;
	}

	public void estTorpilleur() {

		//taille = new Torpilleur().getTaille();
		//futur attribu du bouton
		this.nbSelection = 2;
	}

	public void estSousMarin() {

		//taille = new SousMarin().getTaille();
		//futur attribu du bouton
		this.nbSelection = 1;
	}
}

