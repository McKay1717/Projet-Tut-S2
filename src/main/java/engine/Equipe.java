/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package engine;

import java.util.Arrays;
import java.util.Scanner;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Equipe.
 *
 * @author nicolas
 */
public class Equipe {

	//Grille de l'equipe
	GrilleJeux gj;
	//Si l'equipe a tirer dans le tour passage a true
	static private boolean tirDisponible = false;

	private int CasesBateauNonToucher = 4;
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
	public Equipe(GrilleJeux _gj){
		// Start of user code constructor for Equipe)
		super();
		this.gj = _gj;
		// End of user code
	}


	/*
    * Fonction de tire
    *
     */
	public void tire(Equipe e, int x, int y) {
		//Si la case contient un bateau
		if (!e.gj.cases[x][y].getVide()) {
			e.CasesBateauNonToucher--;
			e.bateaux[4].setTaille(e.bateaux[4].getTaille() - 1);
			System.out.println(" Touché !");
			e.gj.cases[x][y].setTouche(true);
			//si le bateau est coulé (taille = 0)
			if (e.bateaux[4].getTaille() == 0) {
				e.bateaux[4].setEstCoule(true);
				System.out.println(" Coulé !");
			}
		} else {
			//Si il n'y a rien
			System.out.println("Raté !");

		}
	}


	// Start of user code (user defined methods for Equipe)
	/*
   * Placement du torpilleur
   *
    */
	public Case[] setPlacement(Scanner input, int taille) {
		Case[] c = new Case[taille];
		int x, y;
		int i = 0;
		//initialisation de la case [0]
		System.out.println("Case 1 : Entrez x et y : ");
		x = input.nextInt();
		y = input.nextInt();			//vérification que la case choisis se trouve dans le tableau 
		while (!(verification(this, x, y)) || !(this.gj.cases[x][y].getVide())){
			System.out.println("Case 1 : Entrez x et y : ");
			x = input.nextInt();
			y = input.nextInt();
		}
		this.gj.cases[x][y].setVide(false);
		c[0] = new Case(this.gj,x,y);
		//intialisation de la case [1]
		System.out.println("Case 2 : Entrez x et y : ");
		x = input.nextInt();
		y = input.nextInt();  			//vérification que la case choisis se trouve a coté de la première et qu'elle se trouve dans le tableau .
		while (!(verification(this, x, y)) || !(verification_adjacent_case2(this, x, y ,c ))|| !(this.gj.cases[x][y].getVide())){
			System.out.println("Erreur.");
			System.out.println("Case 2 : Entrez x et y : ");
			x = input.nextInt();
			y = input.nextInt();
		}
		c[1] = new Case(this.gj,x,y);
		this.gj.cases[x][y].setVide(false);

		for (i = 2; i < taille -1; i++){
			if (c[0].getX() == c[1].getX()){
				System.out.println("Case "+(i+1)+" : Entrez y : ");
				y = input.nextInt();
				while (!(verification(this, x, y)) || !(this.gj.cases[x][y].getVide()) || !(verification_adjacent_y(this, x, y ,c ,i))){
					System.out.println("Erreur.");
					System.out.println("Case "+(i+1)+" : Entrez y : ");
					y = input.nextInt();
				}
			}
			else if (c[0].getY() == c[1].getY()){
				System.out.println("Case "+(i+1)+" : Entrez x : ");
				x = input.nextInt();
				while (!(verification(this, x, y)) || !(this.gj.cases[x][y].getVide()) || !(verification_adjacent_x(this, x, y ,c ,i))){
					System.out.println("Erreur.");
					System.out.println("Case " + (i + 1) + " : Entrez x : ");
					x = input.nextInt();
				}
			}
			c[i] = new Case(this.gj,x,y);
			this.gj.cases[x][y].setVide(false);
		}
		return c;
	}


	protected boolean verification(Equipe e,int a, int b){
		if(a >= 0 && a <= 9 && b >= 0 && b <= 9){
			if(!e.gj.cases[a][b].getTouche())
				return true;
		}
		return false;
	}

	protected boolean verification_adjacent_case2(Equipe e,int x, int y,Case c[]){
		boolean bool=false;
		if (( x == (c[0].getX() +1) &&  y == (c[0].getY())) ||
			(x == (c[0].getX() -1) && y == (c[0].getY())) ||
			(x == (c[0].getX()) &&  y == (c[0].getY() +1)) ||
			(x == (c[0].getX() ) &&  y == (c[0].getY() -1 ))
			){
			if(!e.gj.cases[x][y].getTouche()) {
				bool= true;
			}
		}
		return bool;
	}

	protected boolean verification_adjacent_x(Equipe e,int x, int y,Case c[],int taille){
		boolean bool=false;
		int i;
		int min=c[0].getX();
		int max=c[0].getX();
		for (i=0 ; i< c.length -1; i++){
			if (c[i].getX() > max) max= c[i].getX();
			else if (c[i].getX() < min) min= c[i].getX();
		}
		if ( x == (min +1) ||  x == (min -1) || x == (max+1) || x== max-1 ){
			if(!e.gj.cases[x][y].getTouche()) {
				bool= true;
			}
		}
		return bool;
	}

	protected boolean verification_adjacent_y(Equipe e,int x, int y,Case c[],int taille){
		boolean bool=false;
		int i;
		int min=c[0].getY();
		int max=c[0].getY();
		for (i=0 ; i< taille; i++){
			if (c[i].getY() > max){
				max= c[i].getY();
			}
			else if (c[i].getY() < min){
				min= c[i].getY();
			}
		}
		if ( y == (min +1) ||  y == (min -1) || y == (max+1) || y == (max-1) ){
			if(!e.gj.cases[x][y].getTouche()) {
				bool= true;
			}
		}
		return bool;
	}


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

	public boolean getPeuxTirer(){
		return tirDisponible;
	}

	public void setPeuxTirer(boolean tirDisponible){
		this.tirDisponible=tirDisponible;
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
		if(this.CasesBateauNonToucher == 0) {
			return false;
		}
		return true;
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
	public GrilleJeux getGj() {
		return gj;
	}
	public void setGj(GrilleJeux gj) {
		this.gj = gj;
	}
	public void setBateaux(Bateaux[] bateaux) {
		this.bateaux = bateaux;
	}


}