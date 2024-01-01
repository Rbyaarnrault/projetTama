package modele;

import java.io.Serializable;
import java.util.Arrays;

public abstract class Tamagotchi implements Serializable {

    // Atributs
    protected String nom;
    protected StrategieConstantes strategie; // Instancié dans les sous classes
    protected int dureeVie, vie, hygiene, faim, sommeil, loisir;

    public Tamagotchi(String name) { // Instancie un objet tamagotchi par son nom
        this.nom = name;
        this.strategie = initialiserStrategie();

        this.dureeVie = 0; // Départ du compteur de durée de vie
        this.vie = strategie.getMax_Vie();
        this.hygiene = strategie.getMax_Hygiene();
        this.faim = strategie.getMax_Faim();
        this.sommeil = strategie.getMax_Sommeil();
        this.loisir = strategie.getMAX_Loisir();
    }

    protected abstract StrategieConstantes initialiserStrategie();

    protected void actualiserVie() {
        // Méthode qui va calculer la valeur de "vie" selon la valeur des 2 constantes
        // les plus basses
        // Ici Basé sur le fait faire mourir le tamagotchi si 2 attribut atteignent 0

        int[] constantes = { hygiene, faim, sommeil, loisir };

        // Tri du tableau dans l'ordre croissant
        Arrays.sort(constantes);

        // Calcul de la moyenne des trois constantes les plus basses
        int moyenne = (constantes[0] + constantes[1]) / 2;

        if (vie >= strategie.getMin_Vie()) {
            vie = moyenne;
        } else {
            vie = strategie.getMin_Vie();
        }

    }

    public void ajouterSecondeDuree() {
        setDureeVie(getDureeVie() + 1);
        ;
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
        faim = decrecrementerValeur(faim, strategie.getDec_Faim(), strategie.getMin_Faim());
        hygiene = decrecrementerValeur(hygiene, strategie.getDec_Hygiene(), strategie.getMin_Hygiene());
        sommeil = decrecrementerValeur(sommeil, strategie.getDec_Sommeil(), strategie.getMin_Sommeil());
        loisir = decrecrementerValeur(loisir, strategie.getDec_Loisir(), strategie.getMin_Loisir());
        actualiserVie();
    }

    // -----Etat Tamagotchi-----

    public void manger() {
        // Incrémentation de l'attribut faim par la constante INC_
        faim = incrementerValeur(faim, strategie.getInc_Faim(), strategie.getMax_Faim());
    }

    public int dormir() {
        // Incrémentation de l'attribut sommeil par la constante INC_SOMMEIL
        sommeil = incrementerValeur(sommeil, strategie.getInc_Sommeil(), strategie.getMax_Sommeil());
        return sommeil;
    }

    public int laver() {
        // Incrémentation de l'attribut hygiene par la constante INC_HYGIENE
        hygiene = incrementerValeur(hygiene, strategie.getInc_Hygiene(), strategie.getMax_Hygiene());
        return hygiene;
    }

    public int jouer() {
        // Incrémentation de l'attribut loisir par la constante INC_LOISIR
        loisir = incrementerValeur(loisir, strategie.getInc_Loisir(), strategie.getMAX_Loisir());
        return loisir;
    }

    // -----Getters-----
    public String getNom() {
        return nom;
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
