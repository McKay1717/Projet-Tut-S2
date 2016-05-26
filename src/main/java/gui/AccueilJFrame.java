/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package gui;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.JFrame;
import javax.swing.JPanel;

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

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 6984202546554955770L;

	/**
	 * The constructor.
	 */
	public AccueilJFrame()
	{
		// Start of user code constructor for AccueilJFrame)
		super();
		// End of user code
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
