package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import engine.Equipe;
import engine.GrilleJeux;
import gui.AccueilJFrame;
import gui.AccueilJPanel;
import gui.FenetreJeux;
import gui.MenuSuperieurJMenuBar;


import static javax.swing.SwingUtilities.invokeLater;

/**
 * Created by Tanguy on 04/06/2016.
 */
public class MenuListener implements ActionListener
{
	MenuSuperieurJMenuBar	menuSuperieurJMenuBar;
	AccueilJFrame			accueilJFrame;
	AccueilJPanel			accueilJPanel;
	FenetreJeux fenetreJeux;


	public MenuListener(MenuSuperieurJMenuBar menuSuperieurJMenuBar, AccueilJFrame accueilJFrame)
	{
		this.menuSuperieurJMenuBar = menuSuperieurJMenuBar;
		this.accueilJFrame = accueilJFrame;
	}
	public MenuListener(MenuSuperieurJMenuBar menuSuperieurJMenuBar, FenetreJeux fenetreJeux) {
		this.fenetreJeux = fenetreJeux;
		this.menuSuperieurJMenuBar = menuSuperieurJMenuBar;
	}

	public void newGame(){
		invokeLater(new Runnable()
		{
			public void run()
			{
				GrilleJeux grilleJeux2 = new GrilleJeux();
				GrilleJeux grilleJeux1 = new GrilleJeux();

				Equipe equipes1 = new Equipe(grilleJeux1, "");
				Equipe equipes2 = new Equipe(grilleJeux2, "");

				Equipe[] equipes = new Equipe[] { equipes1, equipes2 };

				grilleJeux1.setEquipes(equipes);
				grilleJeux2.setEquipes(equipes);

				new GroupListener(grilleJeux1, grilleJeux2, equipes1, equipes2);
			}
		});
	}

	public void newGame(String nom1, String nom2){
		invokeLater(new Runnable()
		{
			public void run()
			{
				GrilleJeux grilleJeux2 = new GrilleJeux();
				GrilleJeux grilleJeux1 = new GrilleJeux();

				Equipe equipes1 = new Equipe(grilleJeux1, nom1);
				Equipe equipes2 = new Equipe(grilleJeux2, nom2);

				Equipe[] equipes = new Equipe[] { equipes1, equipes2 };

				grilleJeux1.setEquipes(equipes);
				grilleJeux2.setEquipes(equipes);

				new GroupListener(grilleJeux1, grilleJeux2, equipes1, equipes2);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == menuSuperieurJMenuBar.getItemInfo1())
		{
			menuSuperieurJMenuBar.getMessage().showMessageDialog(menuSuperieurJMenuBar.getMessage(),
					menuSuperieurJMenuBar.getSignature(), "Information", JOptionPane.INFORMATION_MESSAGE);
		}
		//Arret total du jeu
		if (e.getSource() == menuSuperieurJMenuBar.getItemOptionPlay3())
		{
			System.exit(0);
		}

		//Anuler la partie
		if (e.getSource() == menuSuperieurJMenuBar.getItemOptionPlay1())
		{
				fenetreJeux.setVisible(false);
				newGame();
		}
		//Recommencer la partie
		if (e.getSource() == menuSuperieurJMenuBar.getItemOptionPlay2()) {
			String nom1 = fenetreJeux.getEquipes()[0].getNomEquipe();
			String nom2 = fenetreJeux.getEquipes()[1].getNomEquipe();

			fenetreJeux.setVisible(false);
			newGame(nom1,nom2);
		}

		//Son ON
		if (e.getSource() == menuSuperieurJMenuBar.getItemAudio1())
		{
			fenetreJeux.getEquipes()[0].getJukebox().activeSon(true);
			fenetreJeux.getEquipes()[1].getJukebox().activeSon(true);

		}
		//Son OFF
		if (e.getSource() == menuSuperieurJMenuBar.getItemAudio2())
		{
			fenetreJeux.getEquipes()[0].getJukebox().activeSon(false);
			fenetreJeux.getEquipes()[1].getJukebox().activeSon(false);

		}
	}
}

