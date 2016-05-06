package engine;

/**
 * Created by valenza on 05/05/16.
 */
public class Appli {
    public static void main(String[] args) {
        Equipe equipe1 = new Equipe(new GrilleJeux());
        Equipe equipe2 = new Equipe(new GrilleJeux());

        while (equipe1.equipeEnVie() && equipe2.equipeEnVie()){
            equipe1.tire(equipe2);
            if(equipe2.equipeEnVie()) {
                equipe2.tire(equipe1);
            }
        }
        if (equipe1.equipeEnVie()){
            System.out.println(equipe2.getNomEquipe() + " est vainqueur");
        } else {
            System.out.println(equipe1.getNomEquipe() + " est vainqueur");
        }
    }
}
