package engine;

import java.util.Scanner;

/**
 * Created by valenza on 05/05/16.
 */
public class Appli {
	static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

		Equipe equipe1 = new Equipe(new GrilleJeux());
		Equipe equipe2 = new Equipe(new GrilleJeux());
		Equipe[] equipes = new Equipe[] { equipe1, equipe2 };
        int x, y;
	//	GrilleJeux gj1 = new GrilleJeux(0);
	//	gj1.setEquipes(equipes);
	//	GrilleJeux gj2 = new GrilleJeux(1);
	//	gj2.setEquipes(equipes);
        

        for (int i = 0; i < 2; i++) {
            System.out.println("Choisissez un nom d'equipe " + i );
            equipes[i]. setNomEquipe(input.next());
          //  equipes[i].getBateaux()[0] = new Torpilleur(equipes[i].setPlacement(input, 2), equipes[i]);
          //  equipes[i].getBateaux()[1] = new ContretTorpilleur(equipes[i].setPlacement(input, 3), equipes[i]);
           // equipes[i].getBateaux()[2] = new SousMarin(equipes[i].setPlacement(input, 3), equipes[i]);
           // equipes[i].getBateaux()[3] = new Croiseur(equipes[i].setPlacement(input, 4), equipes[i]);
            equipes[i].getBateaux()[4] = new PorteAvion(equipes[i].setPlacement(input, 5), equipes[i]);

        }

        while (equipe1.equipeEnVie() && equipe2.equipeEnVie()){
            String s = "Tirer sur quel case ?";

            System.out.println("Au tour de " + equipe1.getNomEquipe());
            x = -1;
            y = -1;
            while(!equipe1.verification(equipe2,x,y)) {
                System.out.println(s);
                x = input.nextInt();
                y = input.nextInt();
                s ="Vous avez deja tirer dessus !";
            }
            equipe1.tire(equipe2, x, y);

            x = -1;
            y = -1;
            if(equipe2.equipeEnVie()) {
                s = "Tirer sur quel case ?";
                System.out.println("Au tour de " + equipe2.getNomEquipe());
                while(!equipe2.verification(equipe1,x,y)) {
                    System.out.println(s);
                    x = input.nextInt();
                    y = input.nextInt();
                    s ="Vous avez deja tirer dessus !";
                }
                equipe2.tire(equipe1, x, y);
            }
        }
        if (!equipe1.equipeEnVie()){
            System.out.println(equipe2.getNomEquipe() + " est vainqueur");
        } else {
            System.out.println(equipe1.getNomEquipe() + " est vainqueur");
        }
    }
}
