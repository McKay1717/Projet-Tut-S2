/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package gui;

// Start of user code (user defined imports)
import javax.swing.JButton;

import engine.Case;

// End of user code

/**
 * Description of CaseJButton.
 * 
 * @author nicolas
 */
public class CaseJButton extends JButton
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6683172863248370961L;

	// Start of user code (user defined attributes for CaseJButton)
	public int x;				//Abscisse de la case.
	public int y;				//Ordonnée de la case.
	public Case case_model;
	// End of user code

	/**
	 * The constructor.
	 */
	public CaseJButton(Case case_model)
	{
		super();
		this.case_model = case_model;
		this.x = getX();
		this.y = getY();
	}

	// Start of user code (user defined methods for CaseJButton)

	// End of user code
}