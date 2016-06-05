package gui;

import listener.MenuListener;

import javax.swing.*;
import java.awt.*;


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
	final String signature = new String("Projet informatique semestre 2"
			+System.getProperty("line.separator")+"(session 2015-2016)"
			+System.getProperty("line.separator")+"Programmé par :"
			+System.getProperty("line.separator")+"BORDY Tanguy"
			+System.getProperty("line.separator")+"COUTURIEUX Victor"
			+System.getProperty("line.separator")+"LAROYENNE Guillaume"
			+System.getProperty("line.separator")+"MARTIN Florent"
			+System.getProperty("line.separator")+"SALVI Tom"
			+System.getProperty("line.separator")+"IUNG Nicolas"
			+System.getProperty("line.separator")+"VALENZA Pierre"
			+System.getProperty("line.separator")+"VAISSIERE Floriant");

	//icone
	private final ImageIcon iconeInfo = new ImageIcon(new ImageIcon(rep+"info.jpg").getImage().getScaledInstance(30,30,0));
	private final ImageIcon iconeRestart = new ImageIcon(new ImageIcon(rep+"restart.png").getImage().getScaledInstance(30,30,0));
	private final ImageIcon iconeSonOn = new ImageIcon(new ImageIcon(rep+"sonOn.jpg").getImage().getScaledInstance(30,30,0));
	private final ImageIcon iconeSonOff = new ImageIcon(new ImageIcon(rep+"sonOff.jpg").getImage().getScaledInstance(30,30,0));
	private final ImageIcon iconeStop = new ImageIcon(new ImageIcon(rep+"stop.png").getImage().getScaledInstance(30,30,0));

	//JMenu
	private JMenu optionPlay;
	private JMenu audio;
	private JMenu info;

	//JMenuItem optionPlay
	private JMenuItem itemOptionPlay1;
	private JMenuItem itemOptionPlay2;

	//JMenuItem audio
	private JMenuItem itemAudio1;
	private JMenuItem itemAudio2;

	//JMenuItem info
	private JMenuItem itemInfo1;

	//Listener du JMenuBar
	private MenuListener menuListener;
	private AccueilJFrame accueilJFrame;
	private AccueilJPanel accueilJPanel;
	private FenetreJeux fenetreJeux;
	private JPanel jPanel;

	/**
	 * The constructor.
	 */
	public MenuSuperieurJMenuBar(AccueilJFrame accueilJFrame,AccueilJPanel accueilJPanel) {
		super();
		this.accueilJFrame=accueilJFrame;
		this.accueilJPanel=accueilJPanel;
		this.jPanel=accueilJFrame.getjPanel();
		initAttribut();
		creerJMenuBar2();
	}

	public MenuSuperieurJMenuBar(AccueilJFrame accueilJFrame) {
		super();
		this.accueilJFrame=accueilJFrame;
		this.jPanel=accueilJFrame.getjPanel();
		initAttribut();
		if(this.jPanel==this.accueilJPanel){
			creerJMenuBar2();
		}else {
			creerJMenuBar();
		}
	}

	public MenuSuperieurJMenuBar(FenetreJeux fenetreJeux){
		super();
		this.fenetreJeux=fenetreJeux;
		//this.jPanel=accueilJFrame.getjPanel();
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

		itemAudio1 = new JMenuItem("ON");
		itemAudio2 = new JMenuItem("OFF");

		itemInfo1 = new JMenuItem("Createurs");
		menuListener= new MenuListener(this,this.accueilJFrame);
		itemOptionPlay1.addActionListener(menuListener);
		itemOptionPlay2.addActionListener(menuListener);
		itemAudio1.addActionListener(menuListener);
		itemAudio2.addActionListener(menuListener);
		itemInfo1.addActionListener(menuListener);
	}


	private void creerJMenuBar(){

		//Ajout des icones
		itemOptionPlay1.setIcon(iconeStop);
		itemOptionPlay2.setIcon(iconeRestart);

		itemAudio1.setIcon(iconeSonOn);
		itemAudio2.setIcon(iconeSonOff);

		itemInfo1.setIcon(iconeInfo);

		//Color
		itemAudio1.setBackground(Color.white);
		itemAudio2.setBackground(Color.white);
		itemInfo1.setBackground(Color.white);
		itemOptionPlay1.setBackground(Color.white);
		itemOptionPlay2.setBackground(Color.white);

		//Mise en plan du JMenu
		optionPlay.add(itemOptionPlay1);
		optionPlay.add(itemOptionPlay2);

		audio.add(itemAudio1);
		audio.add(itemAudio2);

		info.add(itemInfo1);

		//Ajout dans le JMenuBar
		this.add(optionPlay);
		this.add(audio);
		this.add(info);
	}
	private void creerJMenuBar2(){

		itemAudio1.setIcon(iconeSonOn);
		itemAudio2.setIcon(iconeSonOff);

		itemInfo1.setIcon(iconeInfo);

		//Color
		itemAudio1.setBackground(Color.white);
		itemAudio2.setBackground(Color.white);
		itemInfo1.setBackground(Color.white);


		audio.add(itemAudio1);
		audio.add(itemAudio2);

		info.add(itemInfo1);

		//Ajout dans le JMenuBar
		this.add(audio);
		this.add(info);
	}

	public JMenuItem getItemInfo1() {
		return itemInfo1;
	}

	public JMenuItem getItemAudio1() {
		return itemAudio1;
	}

	public JMenuItem getItemAudio2() {
		return itemAudio2;
	}

	public JMenuItem getItemOptionPlay1() {
		return itemOptionPlay1;
	}

	public JMenuItem getItemOptionPlay2() {
		return itemOptionPlay2;
	}

	public static JOptionPane getMessage() {
		return message;
	}

	public String getSignature() {
		return signature;
	}

	public AccueilJPanel getAccueilJPanel() {
		return accueilJPanel;
	}

	public void setAccueilJPanel(AccueilJPanel accueilJPanel) {
		this.accueilJPanel = accueilJPanel;
	}
}
