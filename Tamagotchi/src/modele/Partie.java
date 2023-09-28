package modele;

import controlleur.SauvegarderPartie;

public class Partie {

    private Tamagotchi tamagotchi;

    public Partie(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;
    }

    public void sauvergarderPartie() {
        SauvegarderPartie sauvegarde = new SauvegarderPartie();
    }
}
