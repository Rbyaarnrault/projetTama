package modele;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Tamagotchi {

    // Constantes pour les valeurs limites maximales
    private static final int MIN_VIE = 0, MAX_VIE = 100;
    private static final int MIN_HYGIENE = 0, MAX_HYGIENE = 100;
    private static final int MIN_FAIM = 0, MAX_FAIM = 100;
    private static final int MIN_SOMMEIL = 0, MAX_SOMMEIL = 100;
    private static final int MIN_LOISIR = 0, MAX_LOISIR = 100;

    // Constantes pour les incrémentation et decrémentations
    private static final int DEC_VIE = 1, INC_VIE = 30;
    private static final int DEC_HYGIENE = 2, INC_HYGIENE = 30;
    private static final int DEC_FAIM = 2, INC_FAIM = 30;
    private static final int DEC_SOMMEIL = 2, INC_SOMMEIL = 30;
    private static final int DEC_LOISIR = 2, INC_LOISIR = 30;

    // Atributs
    private String nom, type;
    private int dureeVie, vie, hygiene, faim, sommeil, loisir;

    public Tamagotchi(String name, String type) { // Instancie un objet tamagotchi par son nom
        if ((type.equals("Chien")) || (type.equals("Chat")) || (type.equals("Robot"))) {
            this.nom = name;
            this.type = type;
            this.dureeVie = 0; // Départ du compteur de durée de vie
            this.vie = 100;
            this.hygiene = 100;
            this.faim = 100;
            this.sommeil = 100;
            this.loisir = 100;

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

    // Méthode utilitaire pour décrémenter une valeur jusqu'à un minimum
    private int decrecrementerValeur(int valeur, int decrement, int min) {
        if (valeur >= min + decrement) {
            valeur -= decrement;
        } else {
            valeur = min;
        }
        return valeur;
    }

    public void decrementer() {
        // Diminution selon les constantes chosies des attributs
        vie = decrecrementerValeur(vie, DEC_VIE, MIN_VIE);
        faim = decrecrementerValeur(vie, DEC_FAIM, MIN_FAIM);
        hygiene = decrecrementerValeur(vie, DEC_HYGIENE, MIN_HYGIENE);
        sommeil = decrecrementerValeur(vie, DEC_SOMMEIL, MIN_SOMMEIL);
        loisir = decrecrementerValeur(vie, DEC_LOISIR, MIN_LOISIR);
    }

    // -----Etat Tamagotchi-----

    public void manger() {
        // Incrémentation de l'attribut faim par la constante INC_
        faim = incrementerValeur(faim, INC_FAIM, MAX_FAIM);
        // return faim;
    }

    public int dormir() {
        // Incrémentation de l'attribut sommeil par la constante INC_SOMMEIL
        sommeil = incrementerValeur(sommeil, INC_SOMMEIL, MAX_SOMMEIL);
        return sommeil;
    }

    public int laver() {
        // Incrémentation de l'attribut hygiene par la constante INC_HYGIENE
        hygiene = incrementerValeur(hygiene, INC_HYGIENE, MAX_HYGIENE);
        return hygiene;
    }

    public int jouer() {
        // Incrémentation de l'attribut loisir par la constante INC_LOISIR
        loisir = incrementerValeur(loisir, INC_LOISIR, MAX_LOISIR);
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
