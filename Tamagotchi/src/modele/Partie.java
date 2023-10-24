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

    public void sauvergarder() {
        sauvegarde = new Sauvegarde();
    }

    public void charger() {

    }

    public void supprimer(){
        
    }

    // ----getters----
    public Tamagotchi getTamagotchi() {
        return tamagotchi;
    }

    public Timer getTempsPartie() {
        return tempsPartie;
    }

    public Sauvegarde getSauvegarde() {
        return sauvegarde;
    }
}