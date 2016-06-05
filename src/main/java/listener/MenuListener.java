package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui.AccueilJFrame;
import gui.AccueilJPanel;
import gui.FenetreJeux;
import gui.MenuSuperieurJMenuBar;

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

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == menuSuperieurJMenuBar.getItemInfo1())
		{
			menuSuperieurJMenuBar.getMessage().showMessageDialog(menuSuperieurJMenuBar.getMessage(),
					menuSuperieurJMenuBar.getSignature(), "Information", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == menuSuperieurJMenuBar.getItemOptionPlay1())
		{
			accueilJFrame.groupListener.resetGame();
			accueilJPanel = new AccueilJPanel(this.accueilJFrame);
			accueilJFrame.setSize(400, 250);
			accueilJFrame.setjPanel(accueilJPanel);
			menuSuperieurJMenuBar.setAccueilJPanel(accueilJPanel);
			accueilJFrame.setLocationRelativeTo(null);

			accueilJFrame.getContentPane().repaint();
			MenuSuperieurJMenuBar menuBar = new MenuSuperieurJMenuBar(this.accueilJFrame, accueilJPanel);
			accueilJFrame.setJMenuBar(menuBar);
			accueilJFrame.setVisible(true);

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

