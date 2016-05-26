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

	public BateauJButton[] PorteAvion
			,Croiseur
			,ContretTorpilleur
			,Torpilleur
			,SousMarin;
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

		PorteAvion = new BateauJButton[5];
		Croiseur = new BateauJButton[4];
		ContretTorpilleur = new BateauJButton[3];
		Torpilleur = new BateauJButton[2];
		SousMarin = new BateauJButton[3];

		for (int i=0;i<PorteAvion.length;i++)
			PorteAvion[i].estPorteAvion();

		for (int i=0;i<Croiseur.length;i++)
			Croiseur[i].estCroiseur();

		for (int i=0;i<ContretTorpilleur.length;i++)
			ContretTorpilleur[i].estContretTorpilleur();

		for (int i=0;i<Torpilleur.length;i++)
			Torpilleur[i].estTorpilleur();

		for (int i=0;i<SousMarin.length;i++)
			SousMarin[i].estSousMarin();

	}

	private void createPanel() {
		//creation des panel de bouton de selection
		JPanel pPorteAvion = new JPanel(new GridLayout(2,1));
		JPanel pCroiseur = new JPanel(new GridLayout(2,1));
		JPanel pContretTorpilleur = new JPanel(new GridLayout(2,1));
		JPanel pTorpilleur = new JPanel(new GridLayout(2,1));
		JPanel pSousMarin = new JPanel(new GridLayout(2,1));

		//creation des label pour indiquer le type de bateaux A ajouter aux panel de bouton de selection
		JLabel lPorteAvion = new JLabel("Porte Avion X1");
		JLabel lCroiseur = new JLabel("Croiseur X1");
		JLabel lContretTorpilleur = new JLabel("Contret Torpilleur X1");
		JLabel lTorpilleur = new JLabel("Torpilleur X2");
		JLabel lSousMarin = new JLabel("Sous Marin X1");

		//creation des Panel de bouton de selection de bateau A ajouter aux panel de bouton de selection
		JPanel pInPorteAvion = new JPanel(new GridLayout(1,5));
		JPanel pInCroiseur = new JPanel(new GridLayout(1,5));
		JPanel pInContretTorpilleur = new JPanel(new GridLayout(1,5));
		JPanel pInTorpilleur = new JPanel(new GridLayout(1,5));
		JPanel pInSousMarin = new JPanel(new GridLayout(1,5));


		///////
		//assamblage des attribut de selection
		//////

		for (int i=0;i<PorteAvion.length;i++)
			pInPorteAvion.add(PorteAvion[i]);

		for (int i=0;i<Croiseur.length;i++)
			pInCroiseur.add(Croiseur[i]);

		for (int i=0;i<ContretTorpilleur.length;i++)
			pInContretTorpilleur.add(ContretTorpilleur[i]);

		for (int i=0;i<Torpilleur.length;i++)
			pInTorpilleur.add(Torpilleur[i]);

		for (int i=0;i<SousMarin.length;i++)
			pInSousMarin.add(SousMarin[i]);

		pPorteAvion.add(lPorteAvion);
		pPorteAvion.add(pInPorteAvion);

		pCroiseur.add(lCroiseur);
		pCroiseur.add(pInCroiseur);

		pContretTorpilleur.add(lContretTorpilleur);
		pContretTorpilleur.add(pInContretTorpilleur);

		pTorpilleur.add(lTorpilleur);
		pTorpilleur.add(pInTorpilleur);

		pSousMarin.add(lSousMarin);
		pSousMarin.add(pInSousMarin);


		add(pPorteAvion);
		add(pCroiseur);
		add(pContretTorpilleur);
		add(pTorpilleur);
		add(pSousMarin);

		setLayout(new GridLayout(5,1));

	}



	// End of user code

}
