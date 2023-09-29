package modele;

import javax.swing.Timer;

import controlleur.SauvegarderPartie;

public class Partie {

    private Tamagotchi tamagotchi;
    private Timer timer;

    public Partie(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;
        this.timer = new Timer(1000, null);
    }

    public Tamagotchi getTamagotchi() {
        return tamagotchi;
    }

    public Timer getTimer() {
        return timer;
    }

    public void sauvergarderPartie() {
        SauvegarderPartie sauvegarde = new SauvegarderPartie();
    }
}