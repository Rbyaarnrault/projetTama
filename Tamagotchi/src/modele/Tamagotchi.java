package modele;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Tamagotchi {

    // Constantes pour les valeurs limites maximales
    private static final int MAX_VIE = 100;
    private static final int MAX_HYGIENE = 100;
    private static final int MAX_FAIM = 100;
    private static final int MAX_SOMMEIL = 100;
    private static final int MAX_LOISIR = 100;
    // Atributs
    private String nom, type;
    private int dureeVie, vie, hygiene, faim, sommeil, loisir;

    public Tamagotchi(String name, String type) { // Instancie un objet tamagotchi par son nom
        if ((type.equals("Chien")) || (type.equals("Chat")) || (type.equals("Robot"))) {
            this.nom = name;
            this.type = type;
            this.dureeVie = 0; // Départ du compteur de durée de vie
            this.vie = 100;
            this.hygiene = 80;
            this.faim = 60;
            this.sommeil = 50;
            this.loisir = 50;

        } else {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Vous devez choisir le type de Tamagotchi !");
        }
    }

    // Méthode utilitaire pour incrémenter une valeur jusqu'à un maximum
    private int incrementerValeur(int valeur, int increment, int max) {
        if (valeur <= max - increment) {
            valeur += increment;
        } else {
            valeur = max;
        }
        return valeur;
    }

    // -----Etat Tamagotchi-----

    public int manger() {
        // Définition de la constante à ajouter
        int increment = 30;
        faim = incrementerValeur(faim, increment, MAX_FAIM);
        return faim;
    }

    public int dormir() {
        int increment = 30;
        sommeil = incrementerValeur(sommeil, increment, MAX_SOMMEIL);
        return sommeil;
    }

    public int laver() {
        int increment = 30;
        hygiene = incrementerValeur(hygiene, increment, MAX_HYGIENE);
        return hygiene;
    }

    public int jouer() {
        int increment = 30;
        loisir = incrementerValeur(loisir, increment, MAX_LOISIR);
        return loisir;
    }

    // -----Getters-----
    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public int getDureeVie() {
        return dureeVie;
    }

    public int getVie() {
        return vie;
    }

    public int getHygiene() {
        return hygiene;
    }

    public int getFaim() {
        return faim;
    }

    public int getSommeil() {
        return sommeil;
    }

    public int getLoisir() {
        return loisir;
    }

    // -----Setters-----
    public void setNom(String n) {
        nom = n;
    }

    public void setVie(int v) {
        vie = v;
    }

    public void setHygiene(int h) {
        hygiene = h;
    }

    public void setFaim(int f) {
        faim = f;
    }

    public void setSommeil(int s) {
        sommeil = s;
    }

    public void setLoisir(int l) {
        loisir = l;
    }

    public void setDureeVie(int d) {
        dureeVie = d;
    }
}
