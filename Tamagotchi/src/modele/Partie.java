package modele;

import javax.swing.Timer;

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
}
