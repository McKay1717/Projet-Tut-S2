/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package gui;

import javax.swing.*;


public class BateauJButton extends JButton{
	// Start of user code (user defined attributes for BateauJButton)
	public String[] tblTypeBateau = {"PorteAvion","Croiseur","ContretTorpilleur","Torpilleur","Topilleur"};
	public String typeBateau;
	public int nbSelection;
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
		//this.typeBateau=tblTypeBateau[0];
		//futur attribu du bouton
		this.nbSelection = 1;
	}

	public void estCroiseur() {
		//this.typeBateau=tblTypeBateau[1];
		//futur attribu du bouton
		this.nbSelection = 1;
	}

	public void estContretTorpilleur() {
		//this.typeBateau=tblTypeBateau[2];
		//futur attribu du bouton
		this.nbSelection = 1;
	}

	public void estTorpilleur() {
		//this.typeBateau=tblTypeBateau[3];
		//futur attribu du bouton
		this.nbSelection = 2;
	}

	public void estSousMarin() {
		//this.typeBateau=tblTypeBateau[4];
		//futur attribu du bouton
		this.nbSelection = 1;
	}
}

