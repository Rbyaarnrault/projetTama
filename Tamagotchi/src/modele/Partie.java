package modele;

import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.event.ActionEvent;

import controlleur.Sauvegarde;

public class Partie {

    private Tamagotchi tamagotchi;
    private Timer timerPartie;
    private int tempsPartie;
    private Sauvegarde sauvegarde;
    // private int tempsActionTimer;

    public Partie(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;

        // temps en seconde depuis la création de la partie
        timerPartie = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tempsPartie += 1; // Temps en secondes de la Partie
            }
        });

        // Démarrez le minuteur
        timerPartie.start();
    }

    public void sauvergarder() {
        sauvegarde = new Sauvegarde();
    }

    public void charger() {

    }

    public void supprimer() {

    }

    // ----getters----
    public Tamagotchi getTamagotchi() {
        return tamagotchi;
    }

    public int getTempsPartie() {
        return tempsPartie;
    }

    public Timer getTimerPartie() {
        return timerPartie;
    }

    public Sauvegarde getSauvegarde() {
        return sauvegarde;
    }
}