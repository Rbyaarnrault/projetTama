package modele;

import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import controlleur.Sauvegarde;

public class Partie implements Serializable {

    private Tamagotchi tamagotchi;
    private static final long serialVersionUID = 1L;
    private static Sauvegarde sauvegarde;
    // private Salle foret, riviere, feu, tente;
    private Meteo meteo;
    private String nomFichier;

    // private int tempsActionTimer;

    public Partie(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;
        // this.foret = new SalleForet();
        // this.riviere = new SalleRiviere();
        // this.feu = new SalleFeu();
        // this.tente = new SalleTente();

        this.meteo = new Meteo();
        sauvegarde = new Sauvegarde();
    }

    public Partie() {
        this.meteo = new Meteo();
        sauvegarde = new Sauvegarde();
    }

    public void sauvergarder() {
        // Génération d'un fichier à nom unique
        nomFichier = genererNomFichierSauvegarde();
        sauvegarde.sauvegarderPartie(this, nomFichier);
    }

    public static Partie chargerDepuisSauvegarde(String cheminSauvegarde) {
        Partie nouvellePartie = new Partie();
        nouvellePartie.charger(cheminSauvegarde);
        return nouvellePartie;
    }

    public void charger(String chemin) {
        sauvegarde.chargerPartie(chemin);
    }

    public void supprimer() {

    }

    public String genererNomFichierSauvegarde() {
        // Logique pour générer un nom de fichier unique pour distinguer les différentes
        // sauvegardes

        // la date et l'heure sont choisis pour rendre le nom du fichier unique
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return "Tamagotchi/src/ressources/sauvegardes/sauvegarde_" + dateFormat.format(new Date()) + ".dat";
    }

    public String[] obtenirSauvegardesDisponibles() {
        // Logique pour obtenir la liste des fichiers de sauvegarde disponibles dans un
        // répertoire donné

        File repertoire = new File("Tamagotchi/src/ressources/sauvegardes");
        return repertoire.list();
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

    public String getNomFichier() {
        return nomFichier;
    }
}