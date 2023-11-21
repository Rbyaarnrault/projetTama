package modele;

import javax.swing.Timer;

import controlleur.Sauvegarde;

public class Partie {

    private Tamagotchi tamagotchi;
    private Timer timerActions, timerPartie;
    private int tempsPartie;
    private Sauvegarde sauvegarde;
    // private int tempsActionTimer;

    public Partie(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;

        // temps en seconde depuis la création de la partie
        timerPartie = new Timer(1000, new ActionListener() { // Correspond à 1/100% de 12h
            @Override
            public void actionPerformed(ActionEvent e) {
                tempsPartie += 1; // Temps en secondes
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