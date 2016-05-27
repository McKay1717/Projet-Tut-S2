/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package gui;

import javax.swing.*;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of AccueilJFrame.
 * 
 * @author nicolas
 */
public class AccueilJFrame extends JFrame
{
	// Start of user code (user defined attributes for AccueilJFrame)
	private JPanel				jPanel;

	// End of user code

	private static final long	serialVersionUID	= 6984202546554955770L;

	public AccueilJFrame()
	{
		// Start of user code constructor for AccueilJFrame)
		super();

		FramWidget();

		setSize(400,400);                                // Fixe la taille par défaut
		setLocationRelativeTo(null);                     //position de la fenetre sur l'ordi
		setVisible(true);                                // Affiche la fenetre
		setTitle("Battle-Nav Menu");                       //donne un titre au jFrame
		//setIconImage(...)                              //associer une icon a la fenetre
		setResizable(false);                             //empaiche la redimention du JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Gestion de la fermeture
		// End of user code
	}

	public void FramWidget(){

		AccueilJPanel pAccueil = new AccueilJPanel(this);





		///setContentPane(...);
	}

	// Start of user code (user defined methods for AccueilJFrame)

	public JPanel getjPanel()
	{
		return jPanel;
	}

	public void setjPanel(JPanel jPanel)
	{
		this.jPanel = jPanel;
	}

	public void creerDialogError(String message)
	{
		showMessageDialog(this, message, "Erreur", ERROR_MESSAGE);
	}





	// End of user code

}
