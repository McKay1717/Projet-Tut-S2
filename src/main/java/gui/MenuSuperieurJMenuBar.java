package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * Description of MenuSuperieurJMenuBar.
 * 
 * @author guillaume
 */
public class MenuSuperieurJMenuBar extends JMenuBar{
	//Chemin du repertoire des icones
	static final String rep = "src/main/java/gui/icone/";

	//Dialog Message
	private static final JOptionPane message = new JOptionPane();

	//Message info
	final String signature = new String("Projet informatique semestre 2"+System.getProperty("line.separator")+"(session 2015-2016)"+System.getProperty("line.separator")+"Programmé par :" +System.getProperty("line.separator")+"nom1"+System.getProperty("line.separator")+"nom2"+System.getProperty("line.separator")+"nom3" +System.getProperty("line.separator")+"nom3"+System.getProperty("line.separator")+"nom4"+System.getProperty("line.separator")+"nom5"+System.getProperty("line.separator")+"SALVI Tom" +System.getProperty("line.separator")+"LAROYENNE Guillaume");

	//icone
	private final ImageIcon iconeInfo = new ImageIcon(new ImageIcon(rep+"info.jpg").getImage().getScaledInstance(30,30,0));
	private final ImageIcon iconeRestart = new ImageIcon(new ImageIcon(rep+"restart.png").getImage().getScaledInstance(30,30,0));
	private final ImageIcon iconeSonOn = new ImageIcon(new ImageIcon(rep+"sonOn.jpg").getImage().getScaledInstance(30,30,0));
	private final ImageIcon iconeSonOff = new ImageIcon(new ImageIcon(rep+"sonOff.jpg").getImage().getScaledInstance(30,30,0));
	private final ImageIcon iconeStop = new ImageIcon(new ImageIcon(rep+"stop.png").getImage().getScaledInstance(30,30,0));
	private final ImageIcon iconePause = new ImageIcon(new ImageIcon(rep+"pause.png").getImage().getScaledInstance(30,30,0));

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
		action();
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

		//Ajout des icones
		itemOptionPlay1.setIcon(iconeStop);
		itemOptionPlay2.setIcon(iconeRestart);
		itemOptionPlay3.setIcon(iconePause);

		itemAudio1.setIcon(iconeSonOn);
		itemAudio2.setIcon(iconeSonOff);

		itemInfo1.setIcon(iconeInfo);

		//Color
		itemAudio1.setBackground(Color.white);
		itemAudio2.setBackground(Color.white);
		itemInfo1.setBackground(Color.white);
		itemOptionPlay1.setBackground(Color.white);
		itemOptionPlay2.setBackground(Color.white);
		itemOptionPlay3.setBackground(Color.white);

		//Mise en plan du JMenu
		optionPlay.add(itemOptionPlay1);
		optionPlay.add(itemOptionPlay2);
		optionPlay.add(itemOptionPlay3);

		audio.add(itemAudio1);
		audio.add(itemAudio2);

		info.add(itemInfo1);

		//Ajout dans le JMenuBar
		this.add(optionPlay);
		this.add(audio);
		this.add(info);
	}

	private void action(){
		itemInfo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				message.showMessageDialog( message,signature, "Information",  JOptionPane.INFORMATION_MESSAGE);
			}
		});

		itemOptionPlay1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){

			}
		});

		itemOptionPlay2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){

			}
		});

		itemOptionPlay3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){

			}
		});

		itemAudio1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){

			}
		});

		itemAudio2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){

			}
		});
	}
}
