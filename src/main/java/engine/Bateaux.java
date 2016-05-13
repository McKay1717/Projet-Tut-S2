/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package engine;

import java.util.Arrays;

import engine.Equipe;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Bateaux.
 * 
 * @author nicolas
 */
public abstract class Bateaux {
	/**
	 * Description of the property taille.
	 */
	 int taille = -1;

	/**
	 * Description of the property cases.
	 */
	 Case[] cases ;

	/**
	 * Description of the property equipe.
	 */
	public Equipe equipe;

	/**
	 * Description of the property estCoule.
	 */
	public boolean estCoule = false;

	/**
	 * Description of the property equipes.
	 */
	public Equipe equipes = null;

	// Start of user code (user defined attributes for Bateaux)

	// End of user code

	/**
	 * The constructor.
	 */
	public Bateaux(Case[] c, Equipe e) {
		// Start of user code constructor for Bateaux)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Bateaux)

	// End of user code
	/**
	 * Returns taille.
	 * @return taille 
	 */
	public int getTaille() {
		return this.taille;
	}

	/**
	 * Sets a value to attribute taille. 
	 * @param newTaille 
	 */
	public void setTaille(int newTaille) {
		this.taille = newTaille;
	}

	/**
	 * Returns cases.
	 * @return cases 
	 */
	public Case[] getCases() {
		return this.cases;
	}

	/**
	 * Returns equipe.
	 * @return equipe 
	 */
	public Equipe getEquipe() {
		return this.equipe;
	}

	/**
	 * Sets a value to attribute equipe. 
	 * @param newEquipe 
	 */
	public void setEquipe(Equipe newEquipe) {
		this.equipe = newEquipe;
	}

	/**
	 * Returns estCoule.
	 * @return estCoule 
	 */
	public boolean getEstCoule() {
		return this.estCoule;
	}

	/**
	 * Sets a value to attribute estCoule. 
	 * @param newEstCoule 
	 */
	public void setEstCoule(boolean newEstCoule) {
		if (this.taille==(Case.length()).getTouche() && !Case.vide)
			this.estCoule = newEstCoule;
	}

	/**
	 * Returns equipes.
	 * @return equipes 
	 */
	public Equipe getEquipes() {
		return this.equipes;
	}

	/**
	 * Sets a value to attribute equipes. 
	 * @param newEquipes 
	 */
	public void setEquipes(Equipe newEquipes) {
		this.equipes = newEquipes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(cases);
		result = prime * result + ((equipe == null) ? 0 : equipe.hashCode());
		result = prime * result + ((equipes == null) ? 0 : equipes.hashCode());
		result = prime * result + (estCoule ? 1231 : 1237);
		result = prime * result + taille;
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
		Bateaux other = (Bateaux) obj;
		if (!Arrays.equals(cases, other.cases))
			return false;
		if (equipe == null) {
			if (other.equipe != null)
				return false;
		} else if (!equipe.equals(other.equipe))
			return false;
		if (equipes == null) {
			if (other.equipes != null)
				return false;
		} else if (!equipes.equals(other.equipes))
			return false;
		if (estCoule != other.estCoule)
			return false;
		if (taille != other.taille)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bateaux [taille=" + taille + ", cases=" + Arrays.toString(cases) + ", equipe=" + equipe + ", estCoule="
				+ estCoule + ", equipes=" + equipes + "]";
	}

}
