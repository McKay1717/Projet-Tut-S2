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
    static final Scanner input = new Scanner(System.in);
    //Grille de l'equipe
    GrilleJeux gj;

    private int CasesBateauNonToucher = 2;
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
	public Equipe(GrilleJeux gj) {
		// Start of user code constructor for Equipe)
		super();
        this.gj = gj;

        System.out.println("Choisissez un nom d'equipe " );
        setNomEquipe(input.next());

        //Declaration et placement des bateaux
        bateaux[0] = new Torpilleur(getPlacementTorpilleur(),this);

        // End of user code
	}
    /*
    * Placement du torpilleur
    *
     */
    private Case[] getPlacementTorpilleur() {
        Case[] c = new Case[2];
        boolean alignement = false; //Il faut que les cases soit cote a cote pour placer le bateau
        int x, y;
        for ( int i =0 ; i < 2; i++){
            System.out.println("Entrez x et y");
            x = input.nextInt();
            y = input.nextInt();

            //pour la premiere partie, verifié si la case est vide
            if (i == 0) {
                while (!this.gj.cases[x][y].getVide()){
                    System.out.println("Coordonnée non valide en [" + x + "][" + y + "]");
                    System.out.println("Entrez x et y");
                    x = input.nextInt();
                    y = input.nextInt();
                }
            } else {
                //Verifié que la seconde case est a coté de la premiere
                do  {
                    if (((x == (c[0].getX() - 1) && y == (c[0].getY())) || (x == (c[0].getX() + 1) && y == (c[0].getY()))
                            || (x == (c[0].getX()) && y == (c[0].getY() - 1)) || (x == (c[0].getX()) && y == (c[0].getY() + 1)))
                            && this.gj.cases[x][y].getVide()) {
                        alignement = true;
                    } else {
                        System.out.println("Coordonner en [" + x + "][" + y + "] non valide");
                        System.out.println("Entrez x et y");
                        System.out.println(c[0].getX() + " " + c[0].getY());

                        x = input.nextInt();
                        y = input.nextInt();
                    }
                } while(!alignement);
            }
            //attribuer les coordonnées au bateau
            c[i] = new Case(this.gj, x, y);
            c[0].setX(x);
            c[0].setY(y);
            this.gj.cases[x][y].setVide(false);
        }

        return c;
    }

    /*
    * Fonction de tire
    *
     */
    public void tire(Equipe e) {
        int x, y;
        System.out.println("Au tour de " + getNomEquipe());
        System.out.println("Tirer sur quel case ?");
        x = input.nextInt();
        y = input.nextInt();

        //erreur si la case est deja touché
        while(e.gj.cases[x][y].getTouche()){
            System.out.println("Vous avez deja tirer sur cette case ?");
            x = input.nextInt();
            y = input.nextInt();
        }
        e.gj.cases[x][y].setTouche(true);

        //Si la case contient un bateau
        if(!e.gj.cases[x][y].getVide()){
            e.CasesBateauNonToucher--;
            e.bateaux[0].setTaille(e.bateaux[0].getTaille() - 1);
            System.out.println(" Touché !");
            e.gj.cases[x][y].setTouche(false);
            //si le bateau est coulé (taille = 0)
            if(e.bateaux[0].getTaille() == 0) {
                e.bateaux[0].setEstCoule(true);
                System.out.print(" Coulé !");
            }
        } else {
            //Si il n'y a rien
            System.out.println("Raté !");
        }
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


}
