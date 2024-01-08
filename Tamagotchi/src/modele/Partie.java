package modele;

import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import controlleur.Sauvegarde;

public class Partie implements Serializable {

    private Tamagotchi tamagotchi;
    private static final long serialVersionUID = 1L;
    private static Sauvegarde sauvegarde;
    private SalleForet foret;
    private SalleFeu feu;
    private SalleRiviere riviere;
    private SalleTente tente;
    private Meteo meteo;
    private String nomFichier;
    private ArrayList<Salle> listeSalles;
    private Salle salleActuelle;
    private int vitesseTimerDecrement;

    public Partie(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;
        this.meteo = new Meteo();
        sauvegarde = new Sauvegarde();
        vitesseTimerDecrement = 1;

        creerSalles();
        setSalleActuelle("foret"); // On commence toujours une nouvelle Partie dans la foret
    }

    public void creerSalles() {
        this.foret = new SalleForet();
        this.riviere = new SalleRiviere();
        this.feu = new SalleFeu();
        this.tente = new SalleTente();
        this.listeSalles = new ArrayList<Salle>();
        this.listeSalles.add(foret);
        this.listeSalles.add(feu);
        this.listeSalles.add(riviere);
        this.listeSalles.add(tente);

        riviere.setSalleDroite(foret);
        foret.setSalleGauche(riviere);
        foret.setSalleDroite(feu);
        feu.setSalleDroite(tente);
        feu.setSalleGauche(foret);
        tente.setSalleGauche(feu);
    }

    public void sauvergarder() {
        // Génération d'un fichier à nom unique
        nomFichier = genererNomFichierSauvegarde();
        sauvegarde.sauvegarderPartie(this, nomFichier);
    }

    public static Partie charger(String cheminSauvegarde) {
        sauvegarde = new Sauvegarde();
        return sauvegarde.chargerPartie(cheminSauvegarde);
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

    public ArrayList<Salle> getListeSalles() {
        return listeSalles;
    }

    public Salle getSalleActuelle() {
        return salleActuelle;
    }

    public int getVitesseTimerDecrement() {
        return vitesseTimerDecrement;
    }

    public void setVitesseTimerDecrement(int t) {
        vitesseTimerDecrement = t;
    }

    public void setSalleActuelle(String s) {
        // Va permettre au de définir la salle actuelle pour que le tamagotchi fasse les
        // actions qui lui sont possibles dans la salle donnée

        switch (s) {
            case "foret":
                salleActuelle = foret;
                break;
            case "feu":
                salleActuelle = feu;
                break;
            case "riviere":
                salleActuelle = riviere;
                break;
            case "tente":
                salleActuelle = tente;
                break;
            default:
                System.out.println("Erreur: Salle inconnue");
                break;
        }
    }
}