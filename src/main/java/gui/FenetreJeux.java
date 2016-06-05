package gui;

import engine.Equipe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static gui.GrilleDeJeuJPanel.TAILLE_GRILLE;

public class FenetreJeux extends JFrame
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 7002519433302593785L;
	Equipe[]					equipes;									// equipe
																			// =>
																			// grille
																			// =>
																			// case
																			// =>
																			// si
																			// il
																			// y
																			// a
																			// un
																			// bateau
	MenuSuperieurJMenuBar		menuBar;
	public GrilleDeJeuJPanel	deJeuJPanel1;
	public GrilleDeJeuJPanel	deJeuJPanel2;

	public FenetreJeux(Equipe[] e)
	{
		equipes = e;
		creerWidget();
		setTitle("Jeux");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void creerWidget()
	{
		menuBar = new MenuSuperieurJMenuBar(this);
		setJMenuBar(menuBar);

		deJeuJPanel1 = new GrilleDeJeuJPanel(equipes[0].getGj());
		deJeuJPanel2 = new GrilleDeJeuJPanel(equipes[1].getGj());

		JPanel pPrinc = new JPanel();
		JPanel pGrille = new JPanel();
		JPanel pLabel = new JPanel();

		JLabel afficheNomEquipeCourant = new JLabel("C'est au tour de l'equipe "+equipes[1].getNomEquipe()+" de jouer");
		afficheNomEquipeCourant.setFont(new Font("Bitstream Charter",Font.BOLD,20));

		pGrille.add(deJeuJPanel1);
		pLabel.add(afficheNomEquipeCourant);

		pPrinc.add(pLabel,BorderLayout.NORTH);
		pPrinc.add(pGrille,BorderLayout.SOUTH);

		setContentPane(pPrinc);
	}

	public void setListener(ActionListener actionListener)
	{
		for (int i = 0 ; i < TAILLE_GRILLE ; i++)
			for (int j = 0 ; j < TAILLE_GRILLE ; j++)
				deJeuJPanel1.grille[i][j].addActionListener(actionListener);

		for (int i = 0 ; i < TAILLE_GRILLE ; i++)
			for (int j = 0 ; j < TAILLE_GRILLE ; j++)
				deJeuJPanel2.grille[i][j].addActionListener(actionListener);
	}
}