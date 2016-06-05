package gui;

import static gui.GrilleDeJeuJPanel.TAILLE_GRILLE;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import engine.Equipe;

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
	GrilleDeJeuJPanel			deJeuJPanel1;
	GrilleDeJeuJPanel			deJeuJPanel2;

	public FenetreJeux(Equipe[] e, GrilleDeJeuJPanel deJeuJPanel1, GrilleDeJeuJPanel deJeuJPanel2)
	{
		equipes = e;
		creerWidget();
		this.deJeuJPanel1 = deJeuJPanel1;
		this.deJeuJPanel2 = deJeuJPanel2;
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
		setContentPane(deJeuJPanel1);
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