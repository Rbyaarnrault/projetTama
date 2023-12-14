package modele;

import java.util.Random;

public class Meteo {

    private static final int PLUIE = 0;
    private static final int BEAU_TEMPS = 1;

    private int meteoJeu;

    public Meteo() { // choix random de la meteo au lancement du jeu

        Random random = new Random();
        meteoJeu = random.nextInt(2);
    }

    public void changerMeteo() { // changement de la meteo en cours de jeu
        Random random = new Random();
        meteoJeu = random.nextInt(2);
    }

    public int getMeteoJeu() {
        return meteoJeu;
    }

}
