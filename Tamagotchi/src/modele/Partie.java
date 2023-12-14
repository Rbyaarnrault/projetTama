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

    private Meteo meteo;

    // private int tempsActionTimer;

    public Partie(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;

        meteo = new Meteo();
        int delai = 35; // délai pour le changement de météo
        final int[] cpt = { 0 }; // compteur pour le timer du changement de météo

        // temps en seconde depuis la création de la partie
        timerPartie = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tempsPartie += 1; // Temps en secondes de la Partie
                cpt[0] += 1;

                if (cpt[0] == delai) {
                    meteo.changerMeteo();
                    cpt[0] = 0;
                }
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