package modele;

import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.event.ActionEvent;

import controlleur.Sauvegarde;

public class Partie {

    private Tamagotchi tamagotchi;
    private Sauvegarde sauvegarde;
    private Salle foret, riviere, feu, tente;
    private Meteo meteo;

    // private int tempsActionTimer;

    public Partie(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;
        this.foret = new SalleForet();
        this.riviere = new SalleRiviere();
        this.feu = new SalleFeu();
        this.tente = new SalleTente();

        this.meteo = new Meteo();
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

    public Meteo getMeteo() {
        return meteo;
    }

    public Sauvegarde getSauvegarde() {
        return sauvegarde;
    }
}