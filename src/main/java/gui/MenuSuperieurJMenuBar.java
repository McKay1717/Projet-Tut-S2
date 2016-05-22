/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package gui;
import javax.swing.*;

/**
 * Description of MenuSuperieurJMenuBar.
 * 
 * @author guillaume
 */
public class MenuSuperieurJMenuBar extends JMenuBar{
    


	//JMenu
	private JMenu optionPlay;
	private JMenu audio;
	private JMenu info;

	//JMenuItem optionPlay
	private JMenuItem itemOptionPlay1;
	private JMenuItem itemOptionPlay2;
	private JMenuItem itemOptionPlay3;

	//JMenuItem audio
	private JMenuItem itemAudio1;
	private JMenuItem itemAudio2;

	//JMenuItem info
	private JMenuItem itemInfo1;

	/**
	 * The constructor.
	 */
	public MenuSuperieurJMenuBar() {
		super();

		initAttribut();
		creerJMenuBar();

	}


	private void initAttribut(){
		//JMenu
		optionPlay = new JMenu("Game");
		audio = new JMenu("Audio");
		info = new JMenu("A propos");

		//JMenuItem
		itemOptionPlay1 = new JMenuItem("Abandonner la partie");
		itemOptionPlay2 = new JMenuItem("Recommencer la partie");
		itemOptionPlay3 = new JMenuItem("Pause");

		itemAudio1 = new JMenuItem("ON");
		itemAudio2 = new JMenuItem("OFF");

		itemInfo1 = new JMenuItem("Createurs");

	}

	private void creerJMenuBar(){
		//Mise en plan du JMenu optionAudio
		optionPlay.add(itemOptionPlay1);
		optionPlay.add(itemOptionPlay2);
		optionPlay.add(itemOptionPlay3);

		//Mise en plan du JMenu audio
		audio.add(itemAudio1);
		audio.add(itemAudio2);

		//Mise en plan du JMenu info
		info.add(itemInfo1);

		//Ajout dans le JMenuBar
		this.add(optionPlay);
		this.add(audio);
		this.add(info);
	}

}
