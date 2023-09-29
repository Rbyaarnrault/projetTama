package controlleur;

import javax.swing.JPanel;
import modele.Partie;
import modele.Tamagotchi;
import vue.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TamagotchiControleur {
    private Tamagotchi tamagotchi;
    private TamagotchiFrame fenetre;
    private Partie partie;
    private int tmpFenActive;

    public TamagotchiControleur(TamagotchiFrame fen) {
        // Initialisation de la fenêtre JFrame
        fenetre = fen;
        actualiserContenuFenetre(0); // Initialisation du panel d'accueil
        fenetre.display();

        Timer timer = new Timer(432000, new ActionListener() { // Correspond à 1/100% de 12h
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mise à jour de l'animation Swing ici si nécessaire

            }
        });

        // Démarrez le minuteur
        timer.start();
    }

    public void creerNouvellePartie(String n, String t) {
        // Logique pour créer une nouvelle partie
        tamagotchi = new Tamagotchi(n, t); // Création du tamagotchi en récupérant le contenu des JTextField
        partie = new Partie(tamagotchi);

        actualiserContenuFenetre(2); // Afficher le salon à l'écran
    }

    public void sauvergarderPartie() {
        partie.sauvergarderPartie();
        actualiserContenuFenetre(0);
    }

    public void chargerSauvegarde() {
        // Logique pour charger une sauvegarde
        // Afficher l'écran de la salle en fonction de l'état sauvegardé
        // Débuter toujours dans la foret ?
    }

    public void actualiserContenuFenetre(int choix) {
        fenetre.actualiser(changerDeSalle(choix));
    }

    public void supprimerSauvegarde() {
        // Logique pour supprimer une sauvegarde
    }

    public JPanel changerDeSalle(int choix) {
        // Logique pour changer de salle
        JPanel pan = new JPanel();
        switch (choix) {
            case 0: // Ecran Accueil
                pan = new EcranAccueil(this);
                break;
            case 1: // CréationPartie
                pan = new EcranCreation(this);
                break;
            case 2: // Foret
                pan = new EcranForet(this);
                tmpFenActive = 2;
                break;
            case 3: // Feu de camp
                pan = new EcranFeu(this);
                break;
            case 4: // Tente de survie
                pan = new EcranTente(this);
                break;
            case 5: // Rivière
                pan = new EcranRiviere(this);
                break;
            case 6: // Ecran quitter
                pan = new EcranQuitter(this);
                break;
            default: // En cas de disfonctionnement
                pan = new EcranForet(this);
                break;
        }
        return pan;
    }

    // Etat du Tamagotchi

    public void nourrirTama() {
        // Logique pour la gestion de la faim/nourriture du Tama
        tamagotchi.manger();
        // ligne pour agir sur la vue exemple : JProgressBar barFaim.setFill(n)
    }

    public void dormirTama() {
        // Logique pour la gestion du sommeil/dodo du Tama
        tamagotchi.fatigue();
        // ligne pour agir sur la vue ...
    }

    public void jouerTama() {
        // Logique pour la gestion du loisir/jeu du Tama
        tamagotchi.jouer();
        // ligne pour agir sur la vue
    }

    public void laverTama() {
        // Logique pour la gestion de l'hygiène du Tama
        tamagotchi.proprete();
    }

    public void quitterPartie() {
        // Logique pour quitter la partie
        actualiserContenuFenetre(6);
    }

    public int getTmpFenActive() { // Permet de repérer le dernier écran actif avant sauvegarde
        return tmpFenActive;
    }

    // -----Getters des constantes-----
    public int getVieTama() {
        return tamagotchi.getVie();
    }

    public int getNourritureTama() {
        return tamagotchi.getFaim();
    }

    public int getSommeilTama() {
        return tamagotchi.getSommeil();
    }

    public int getHygieneTama() {
        return tamagotchi.getHygiene();
    }

    public int getLoisirTama() {
        return tamagotchi.getLoisir();
    }
}