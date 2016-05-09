package engine;

import java.util.Scanner;

/**
 * Created by valenza on 05/05/16.
 */
public class Appli {
	static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
		Equipe equipe1 = new Equipe();
		Equipe equipe2 = new Equipe();
		Equipe[] equipes = new Equipe[] { equipe1, equipe2 };
		GrilleJeux gj1 = new GrilleJeux(0);
		gj1.setEquipes(equipes);
		GrilleJeux gj2 = new GrilleJeux(1);
		gj2.setEquipes(equipes);
        
        System.out.println("Choisissez un nom d'equipe 1" );
        equipe1. setNomEquipe(input.next());

        System.out.println("Choisissez un nom d'equipe 2" );
        equipe2. setNomEquipe(input.next());
        
        equipe1.getBateaux()[0] = new Torpilleur(equipe1.getPlacementTorpilleur(input),equipe1);
        equipe2.getBateaux()[0] = new Torpilleur(equipe2.getPlacementTorpilleur(input),equipe2);


        while (equipe1.equipeEnVie() && equipe2.equipeEnVie()){
            equipe1.tire(equipe2,input.nextInt(),input.nextInt());
            if(equipe2.equipeEnVie()) {
                equipe2.tire(equipe1,input.nextInt(),input.nextInt());
            }
        }
        if (equipe1.equipeEnVie()){
            System.out.println(equipe2.getNomEquipe() + " est vainqueur");
        } else {
            System.out.println(equipe1.getNomEquipe() + " est vainqueur");
        }
    }
}
