package modele;

import javax.swing.Timer;

import controlleur.Sauvegarde;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Partie {

    private Tamagotchi tamagotchi;
    private Timer tempsPartie;
    private Sauvegarde sauvegarde;

    public Partie(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;
        Timer tempsPartie = new Timer(1000, null); // temps en seconde depuis la création de la partie

        // Démarrez le minuteur
        tempsPartie.start();
    }

    public Tamagotchi getTamagotchi() {
        return tamagotchi;
    }

    public Timer getTempsPartie() {
        return tempsPartie;
    }

    public void sauvergarderPartie() {
        sauvegarde = new Sauvegarde();
    }

    public Sauvegarde getSauvegarde() {
        return sauvegarde;
    }
}