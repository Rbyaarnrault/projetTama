package modele;

import java.awt.Image;
import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public abstract class Tamagotchi implements Serializable {

    // Atributs
    protected String nom;
    protected StrategieConstantes strategie; // Instancié dans les sous classes
    protected double vie, hygiene, faim, sommeil, loisir;
    protected Boolean estMort;
    protected transient Image imageTamagotchi;
    protected String cheminImage;
    private Instant debutVie, derniereActualisation;
    protected long dureeVie;

    public Tamagotchi(String name) { // Instancie un objet tamagotchi par son nom
        this.nom = name;
        debutVie = Instant.now(); // Fixe l'instant de la création du tamagotchi
        derniereActualisation = debutVie;
        this.strategie = initialiserStrategie();

        this.estMort = false;
        this.dureeVie = 0; // Départ du compteur de durée de vie
        this.vie = strategie.getMax_Vie();
        this.hygiene = strategie.getMax_Hygiene();
        this.faim = strategie.getMax_Faim();
        this.sommeil = strategie.getMax_Sommeil();
        this.loisir = strategie.getMAX_Loisir();
    }

    protected abstract StrategieConstantes initialiserStrategie();

    protected void actualiserVie() {
        // Calcule la valeur de "vie" selon les 2 constantes les plus basses
        // Ici, on veut faire mourir le tamagotchi si 2 attributs sur 4
        // atteignent 0

        double[] constantes = { hygiene, faim, sommeil, loisir };

        // Tri du tableau dans l'ordre croissant
        Arrays.sort(constantes);

        // Calcul de la moyenne des trois constantes les plus basses
        double moyenne = (constantes[0] + constantes[1]) / 2;

        if (vie >= strategie.getMin_Vie()) {
            vie = moyenne;
        } else {
            vie = strategie.getMin_Vie();
        }
    }

    public void calculDureeVie() {
        Instant maintenant = Instant.now(); // Fixe l'instant présent
        Duration dureeEcoulee = Duration.between(debutVie, maintenant);
        long tempsEcouleMillis = dureeEcoulee.toMillis();

        // Calcule en seconde la duree de vie du tamagotchi
        setDureeVie(tempsEcouleMillis / 1000);
    }

    public void actualisationDecrementationConstantes(int vitesseTimerDecr) {

        if (vie > 0) { // Si vie en positif non nul
            // Calcul de la décrémentation depuis la dernière actualisation
            Instant maintenant = Instant.now(); // Fixe l'instant ou j'actualise
            Duration dureeEcoulee = Duration.between(derniereActualisation, maintenant);

            // vitesseTimerDecr permet de faire varier la vitesse d'écoulement du temps
            // entre 1 et 100 fois plus vite
            double tempsEcouleMillis = dureeEcoulee.toMillis() * vitesseTimerDecr;

            // Methode qui va adapter la strategie selon la météo
            // checkConditionMeteo();

            // 6h = 21600000ms : On veut faire mourir le tama en 6h, 6h = 100%
            // donc 1% = 21600000/100 = 216000
            faim -= ((tempsEcouleMillis / 216000) * strategie.DEC_FAIM);
            sommeil -= ((tempsEcouleMillis / 216000) * strategie.DEC_SOMMEIL);
            hygiene -= ((tempsEcouleMillis / 216000) * strategie.DEC_HYGIENE);
            loisir -= ((tempsEcouleMillis / 216000) * strategie.DEC_LOISIR);

            // Sert conserver les valeurs au dessus du min (ou égal)
            faim = Math.max(strategie.MIN_FAIM, faim);
            sommeil = Math.max(strategie.MIN_SOMMEIL, sommeil);
            hygiene = Math.max(strategie.MIN_HYGIENE, hygiene);
            loisir = Math.max(strategie.MIN_LOISIR, loisir);

            // Affectation du temps fixé pour situer la dernière actualisation
            derniereActualisation = maintenant;

            // recalcule la valeur de vie
            actualiserVie();
        } else {
            // On le fait mourir une seule fois et pas à chaques secondes
            if (estMort == false) {
                mourir(); // Sinon faire mourir le tama
                // Evite du processing si le tama est mort
            }
        }
    }

    public void manger() {
        // Incrémentation de la faim par la constante d'incrémentation de faim
        faim += strategie.INC_FAIM;
        faim = Math.min(faim, strategie.MAX_FAIM); // Permet de ne pas dépasse la borne max
    }

    public void dormir() {
        // Incrémentation de la faim par la constante d'incrémentation de sommeil
        sommeil += strategie.INC_SOMMEIL;
        sommeil = Math.min(sommeil, strategie.MAX_SOMMEIL); // Permet de ne pas dépasse la borne max
    }

    public void laver() {
        // Incrémentation de la faim par la constante d'incrémentation de hygiene
        hygiene += strategie.INC_HYGIENE;
        hygiene = Math.min(hygiene, strategie.MAX_HYGIENE);
    }

    public void jouer() {
        // Incrémentation de la faim par la constante d'incrémentation de loisir
        loisir += strategie.INC_LOISIR;
        loisir = Math.min(loisir, strategie.MAX_LOISIR);
    }

    public void mourir() {
        if (getVie() <= 0) {
            // Mise au min de tous les attributs
            estMort = true;
            faim = strategie.getMin_Faim();
            sommeil = strategie.getMin_Sommeil();
            hygiene = strategie.getMin_Hygiene();
            loisir = strategie.getMin_Loisir();

            // Afficher un message informant de la mort
            JOptionPane.showMessageDialog(new JFrame(), "Votre Tamagotchi est mort. Game Over.",
                    "Game Over", JOptionPane.YES_OPTION);
        }
    }

    // -----Getters-----
    public Boolean estMort() {
        return estMort;
    }

    public String getNom() {
        return nom;
    }

    public long getDureeVie() {
        return dureeVie;
    }

    public double getVie() {
        return vie;
    }

    public double getHygiene() {
        return hygiene;
    }

    public double getFaim() {
        return faim;
    }

    public double getSommeil() {
        return sommeil;
    }

    public double getLoisir() {
        return loisir;
    }

    public Image getImage() {
        return this.imageTamagotchi;
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

    public void setDureeVie(long d) {
        dureeVie = d;
    }

    public void setImage(Image i) {
        imageTamagotchi = i;
    }

    public String getCheminImage() {
        return cheminImage;
    }
}
