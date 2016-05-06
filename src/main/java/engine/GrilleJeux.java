/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package engine;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of GrilleJeux.
 * 
 * @author nicolas
 */
public class GrilleJeux {
	/**
	 * Description of the property cases.
	 */
	public Case[][] cases = new Case[10][10];

	// Start of user code (user defined attributes for GrilleJeux)

	// End of user code

	/**
	 * The constructor.
	 */
	/**
	 * Initialise le tableau de 100 case
	 */
	public GrilleJeux() {
		// Start of user code constructor for GrilleJeux)
		super();

		for (int x = 0; x < cases.length; x++) {
			for (int y = 0; y < cases[x].length; y++) {
				cases[x][y] = new Case(this, x, y);
			}
		}


		// End of user code
	}

	// Start of user code (user defined methods for GrilleJeux)

	// End of user code
	/**
	 * Returns cases.
	 * 
	 * @return cases
	 */
	public Case[][] getCases() {
		return this.cases;
	}

}
