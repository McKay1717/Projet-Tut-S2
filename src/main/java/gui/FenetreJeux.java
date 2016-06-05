package gui;

import javax.swing.JFrame;

import engine.Equipe;

public class FenetreJeux extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7002519433302593785L;
	Equipe[] equipes;
	MenuSuperieurJMenuBar menuBar;
	GrilleDeJeuJPanel deJeuJPanel1;
	GrilleDeJeuJPanel deJeuJPanel2;

	public FenetreJeux(Equipe[] e) {
		equipes = e;
		creerWidget();
		setTitle("Jeux");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void creerWidget() {
		//menuBar = new MenuSuperieurJMenuBar();
		setJMenuBar(menuBar);
		deJeuJPanel1 = new GrilleDeJeuJPanel(equipes[0].getGj());
		deJeuJPanel2 = new GrilleDeJeuJPanel(equipes[1].getGj());
		setContentPane(deJeuJPanel1);
	}
}
