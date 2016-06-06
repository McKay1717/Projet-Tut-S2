package gui;

import static gui.GrilleDeJeuJPanel.TAILLE_GRILLE;
import static java.awt.Color.BLUE;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.Equipe;

public class FenetreJeux extends JFrame
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 7002519433302593785L;
	private Equipe[]			equipes;									// equipe
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

	public FenetreJeux(Equipe[] e, GrilleDeJeuJPanel deJeuJPanel1, GrilleDeJeuJPanel deJeuJPanel2)
	{
		this.deJeuJPanel1 = deJeuJPanel1;
		this.deJeuJPanel2 = deJeuJPanel2;
		for (int i = 0 ; i < TAILLE_GRILLE ; i++)
			for (int j = 0 ; j < TAILLE_GRILLE ; j++)
			{
				deJeuJPanel1.grille[i][j].setBackground(BLUE);
				deJeuJPanel2.grille[i][j].setBackground(BLUE);
			}

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

		JPanel pPrinc = new JPanel();
		JPanel pGrille = new JPanel();
		JPanel pLabel = new JPanel();

		JLabel afficheNomEquipeCourant = new JLabel(
				"C'est au tour de l'equipe " + equipes[0].getNomEquipe() + " de jouer");
		afficheNomEquipeCourant.setFont(new Font("Bitstream Charter", Font.BOLD, 20));

		pGrille.add(deJeuJPanel2);
		pLabel.add(afficheNomEquipeCourant);

		pPrinc.add(pLabel, BorderLayout.NORTH);
		pPrinc.add(pGrille, BorderLayout.SOUTH);

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

	public Equipe[] getEquipes()
	{
		return equipes;
	}
}