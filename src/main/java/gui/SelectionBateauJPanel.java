/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package gui;

import engine.GrilleJeux;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static java.awt.Color.BLACK;

/**
 * Description of SelectionBateauJPanel.
 * 
 * @author nicolas
 */
public class SelectionBateauJPanel extends JPanel {
	// Start of user code (user defined attributes for SelectionBateauJPanel)


	public ArrayList<BateauJButton[]> porteAvion
			,croiseur
			,contretTorpilleur
			,torpilleur
			,sousMarin;

	private GrilleJeux grilleJeux;

	// End of user code


	private static final long serialVersionUID = 3937304672276095355L;


	public SelectionBateauJPanel(GrilleJeux grilleJeux) {
		// Start of user code constructor for SelectionBateauJPanel)
		super();
		this.grilleJeux =grilleJeux;

		initPanel();
		createPanel();
		// End of user code
	}


	// Start of user code (user defined methods for SelectionBateauJPanel)
	private void initPanel() {

		porteAvion = new ArrayList<BateauJButton[]>();
		croiseur = new ArrayList<BateauJButton[]>();
		contretTorpilleur = new ArrayList<BateauJButton[]>();
		torpilleur = new ArrayList<BateauJButton[]>();
		sousMarin = new ArrayList<BateauJButton[]>();

		BateauJButton[] bateau = new BateauJButton[5];
		for (int j = 0 ; j < 5 ; j++)
		{
			bateau[j] = new BateauJButton();
			bateau[j].estPorteAvion();
			bateau[j].setBackground(BLACK);
		}
		porteAvion.add(bateau);

		bateau = new BateauJButton[4];
		for (int j = 0 ; j < 4 ; j++)
		{
			bateau[j] = new BateauJButton();
			bateau[j].estCroiseur();
			bateau[j].setBackground(BLACK);
		}
		croiseur.add(bateau);

		bateau = new BateauJButton[3];
		for (int j = 0 ; j < 3 ; j++)
		{
			bateau[j] = new BateauJButton();
			bateau[j].estContretTorpilleur();
			bateau[j].setBackground(BLACK);
		}
		contretTorpilleur.add(bateau);

		bateau = new BateauJButton[3];
		for (int j = 0 ; j < 3 ; j++)
		{
			bateau[j] = new BateauJButton();
			bateau[j].estSousMarin();
			bateau[j].setBackground(BLACK);
		}
		sousMarin.add(bateau);

		bateau = new BateauJButton[2];
		for (int j = 0 ; j < 2 ; j++)
		{
			bateau[j] = new BateauJButton();
			bateau[j].estTorpilleur();
			bateau[j].setBackground(BLACK);
		}
		torpilleur.add(bateau);
	}

	private void createPanel() {
		setLayout(new GridLayout(5,1));


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

		for (int i=0;i<5;i++)
			pInPorteAvion.add(porteAvion.get(0)[i]);

		for (int i=0;i<4;i++)
			pInCroiseur.add(croiseur.get(0)[i]);

		for (int i=0;i<3;i++)
			pInContretTorpilleur.add(contretTorpilleur.get(0)[i]);

		for (int i=0;i<3;i++)
			pInTorpilleur.add(torpilleur.get(0)[i]);

		for (int i=0;i<2;i++)
			pInSousMarin.add(sousMarin.get(0)[i]);

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
		add(pSousMarin);
		add(pTorpilleur);




	}



	// End of user code

}
