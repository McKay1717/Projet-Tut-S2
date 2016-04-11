/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package engine;

import java.util.Arrays;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Equipe.
 * 
 * @author nicolas
 */
public class Equipe {
	/**
	 * Description of the property nomEquipe.
	 */
	 String nomEquipe = "";

	/**
	 * Description of the property bateaux.
	 */
	 Bateaux[] bateaux = new Bateaux[5];

	/**
	 * The constructor.
	 */
	public Equipe() {
		// Start of user code constructor for Equipe)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Equipe)

	// End of user code
	/**
	 * Returns nomEquipe.
	 * @return nomEquipe 
	 */
	public String getNomEquipe() {
		return this.nomEquipe;
	}

	/**
	 * Sets a value to attribute nomEquipe. 
	 * @param newNomEquipe 
	 */
	public void setNomEquipe(String newNomEquipe) {
		this.nomEquipe = newNomEquipe;
	}

	/**
	 * Returns bateaux.
	 * @return bateaux 
	 */
	public Bateaux[] getBateaux() {
		return this.bateaux;
	}
	
	public boolean equipeEnVie()
	{
		return false;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(bateaux);
		result = prime * result + ((nomEquipe == null) ? 0 : nomEquipe.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipe other = (Equipe) obj;
		if (!Arrays.equals(bateaux, other.bateaux))
			return false;
		if (nomEquipe == null) {
			if (other.nomEquipe != null)
				return false;
		} else if (!nomEquipe.equals(other.nomEquipe))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Equipe [nomEquipe=" + nomEquipe + ", bateaux=" + Arrays.toString(bateaux) + "]";
	}

}
