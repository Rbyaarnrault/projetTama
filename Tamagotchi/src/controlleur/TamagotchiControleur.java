package controlleur;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modele.Partie;
import modele.Tamagotchi;
import vue.*;

public class TamagotchiControleur {
    private Tamagotchi tamagotchi;
    private TamagotchiFrame fenetre;
    private Partie partie;

    public TamagotchiControleur(TamagotchiFrame fen) {
        // Initialisation de la fenêtre JFrame
        fenetre = fen;
        actualiserContenuFenetre(0); // Initialisation du panel d'accueil
        fenetre.display();
    }

    public void creerNouvellePartie(String n, String t) {
        // Logique pour créer une nouvelle partie
        tamagotchi = new Tamagotchi(n, t); // Création du tamagotchi en récupérant le contenu des JTextField
        partie = new Partie(tamagotchi);

        actualiserContenuFenetre(2); // Afficher le salon à l'écran
    }

    public void sauvergarderPartie() {
        // Logique pour sauvegarder les données, les attributs

        // partie exportée ?
    }

    public void chargerSauvegarde() {
        // Logique pour charger une sauvegarde
        // Afficher l'écran de la salle en fonction de l'état sauvegardé
        // Débuter toujours dans la foret ?
    }

    public void actualiserContenuFenetre(int choix) {
        fenetre.actualiser(changerDeSalle(choix));
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
            default: // En cas de disfonctionnement
                pan = new EcranForet(this);
                break;
        }
        return pan;
    }

}
