package controlleur;

import javax.swing.JFrame;
import javax.swing.JPanel;
import modele.Partie;
import modele.Tamagotchi;
import vue.*;

public class TamagotchiControleur {
    private TamagotchiFrame fenetre;
    private EcranForet panForet;
    private EcranRiviere panRiviere;
    private EcranFeu panFeu;
    private EcranTente panTente;
    private Partie partie;

    public TamagotchiControleur(TamagotchiFrame fen) {
        // Initialisation de la fenêtre JFrame
        fenetre = fen;
        panForet = new EcranForet(this);
        panRiviere = new EcranRiviere(this);
        panFeu = new EcranFeu(this);
        panTente = new EcranTente(this);
        changerEcran("accueil"); // Initialisation du panel d'accueil
        fenetre.afficher();
    }

    public void creerNouvellePartie(String n, String t) {
        // Logique pour créer une nouvelle partie
        Tamagotchi tama = new Tamagotchi(n, t); // Création du tamagotchi en récupérant le contenu des JTextField
        partie = new Partie(tama);

        changerEcran("feu");
    }

    public void sauvergarderPartie() {
        partie.sauvergarder();
        // remettre accueil
        changerEcran("accueil");
    }

    // -----Gestion de la sauvegarde-----

    public void chargerSauvegarde() {
        // Logique pour charger une sauvegarde
        // Afficher l'écran de la salle en fonction de l'état sauvegardé
        // Débuter toujours dans la foret ?
    }

    public void supprimerSauvegarde() {
        // Logique pour supprimer une sauvegarde
    }

    // --------Choix de l'écran----------
    public void changerEcran(String choix) {
        JPanel pan = new JPanel(); // Nouveau JPanel temporaire qui va être affecté de l'écran voulu

        switch (choix) {
            case "accueil": // Ecran Accueil
                fenetre.setTitle("Accueil");
                pan = new EcranAccueil(this);
                break;

            case "creation": // CréationPartie
                fenetre.setTitle("Création Partie");
                pan = new EcranCreation(this);
                break;

            case "foret": // Ecran Salle Forêt
                fenetre.setTitle("Forêt");
                pan = panForet;
                break;

            case "riviere": // Ecran Salle Rivère
                fenetre.setTitle("Rivière");
                pan = panRiviere;
                break;

            case "feu": // Ecran Salle Feu
                fenetre.setTitle("Feu");
                pan = panFeu;
                break;

            case "tente": // Ecran Salle Tente
                fenetre.setTitle("Tente");
                pan = panTente;
                break;

            case "quitter": // Ecran Salle Quitter
                fenetre.setTitle("Quitter");
                pan = new EcranQuitter(this);
                break;

            case "developpeur": // Ecran Mode Développeur
                fenetre.setTitle("Mode Développeur");
                pan = new EcranDeveloppeur(this); // LINITIALISER A CURSEUR.SET(TAMA.TIMER) ?
                break;
        }
        fenetre.actualiser(pan);

    }

    // -----Action sur le modèle---------

    public void nourrirTama() {
        // Logique pour la gestion de la faim/nourriture du Tama
        partie.getTamagotchi().manger();
    }

    public void dormirTama() {
        // Logique pour la gestion du sommeil/dodo du Tama
        partie.getTamagotchi().dormir();
    }

    public void jouerTama() {
        // Logique pour la gestion du loisir/jeu du Tama
        partie.getTamagotchi().jouer();

    }

    public void laverTama() {
        // Logique pour la gestion de l'hygiène du Tama
        partie.getTamagotchi().laver();
    }

    // -----Getters des constantes-----
    public int getVieTama() {
        return partie.getTamagotchi().getVie();
    }

    public int getNourritureTama() {
        return partie.getTamagotchi().getFaim();
    }

    public int getSommeilTama() {
        return partie.getTamagotchi().getSommeil();
    }

    public int getHygieneTama() {
        return partie.getTamagotchi().getHygiene();
    }

    public int getLoisirTama() {
        return partie.getTamagotchi().getLoisir();
    }

    public JFrame getFrame() {
        return fenetre;
    }
}