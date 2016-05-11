/**
 * Created by guillaume on 10/05/16.
 */
import javazoom.jl.player.advanced.*;
import java.io.*;

// MP3, WMA, MPEG, WAV compatible

public class Jukebox {
    //Indiquer le rep ou se trouvent les son!!!!
    private final String rep = "./BibliSonMP3/";
    
    
    private final String[] listeMP3 = {"304.mp3","684.mp3","689.mp3","alarme1.mp3","coule.mp3","dansLeau.mp3","eau.mp3","estCoule.mp3","explosion.mp3","rocket.mp3","start.mp3","tirerate.mp3","touche.mp3"};
    private final String[] nomSon = {"BruitBulle1","BruitBulle2","BruitBulle3","SousMarin","BruitCoule","TireDansEau","BruitEau","Couler","BruitExplosion","Fire","START","Plouf","Toucher"};

    public Jukebox(){

    }


    public void playSon(String nom){
        try {
            //Initialisation
            String path=new String("");

            //Compteur
            int i;

            //Recherche du son
            for (i=0;i<nomSon.length;i++){
                if(nomSon[i].equals(nom)){
                    path=listeMP3[i];
                    break;
                }
            }

            //Creation de l'adresse
            path=rep+path;

            InputStream in = (InputStream)new BufferedInputStream(new FileInputStream(new File(path)));
            player = new AdvancedPlayer(in);

            play();
        }catch (Exception e){
            displayExeption(e);
        }
    }

    public void playSon(String nom,PlaybackListener listener){
        try {
            //Initialisation
            String path=new String("");

            //Compteur
            int i;

            //Recherche du son
            for (i=0;i<nomSon.length;i++){
                if(nomSon[i].equals(nom)){
                    path=listeMP3[i];
                    break;
                }
            }

            //Creation de l'adresse
            path=rep+path;

            InputStream in = (InputStream)new BufferedInputStream(new FileInputStream(new File(path)));
            player = new AdvancedPlayer(in);
            player.setPlayBackListener(listener);

            play();
        }catch (Exception e){
            displayExeption(e);
        }
    }
    

    private void play(){
        try {
            if (player != null) {
                isPlaying = true;
                player.play();
            }
        }catch (Exception e){

        }
    }

    private void play(int begin,int end){
        try {
            if (player != null) {
                isPlaying = true;
                player.play(begin,end);
            }
        }catch (Exception e){

        }
    }

    public void stop(){
        if (player != null) {
            isPlaying = false;
            player.stop();
        }
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    private boolean isPlaying = false;
    private AdvancedPlayer player = null;

    public String toString(){
        String chaine = new String("");
        //Compteur
        int i;

        for (i=0;i<nomSon.length;i++){
            chaine=chaine+nomSon[i]+" => "+ listeMP3[i]+"; ";
        }
        return chaine;
    }

    public void demo(){
        int i;

        for(i=0;i<nomSon.length;i++){
            playSon(nomSon[i]);
        }
    }

    private void displayExeption(Exception e){
        System.out.println("Erreur de lecture du fichier, verfier que le nom est correct");
        System.out.println("Error :");
        System.out.println(e);
        System.out.println(this);
    }
}