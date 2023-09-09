package controlleur;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modele.Tamagotchi;
import vue.*;

public class TamagotchiControleur {
    private Tamagotchi tamagotchi;
    private TamagotchiFrame fenetre;
    private EcranAccueil ecranAccueil;
    private EcranSalon ecranSalon;
    private EcranCuisine ecranCuisine;
    private EcranJardin ecranJardin;
    private EcranSalleBain ecranSalleBain;

    public TamagotchiControleur(TamagotchiFrame fen) {
        // Initialisation du Tamagotchi, des écrans et de la fenêtre JFrame
        fenetre = fen;
        changerDeSalle(0);
        fenetre.display();
        // Gestion des événements utilisateur pour créer une nouvelle partie, charger
        // une sauvegarde,
        // changer de salle, etc.
    }

    public void creerNouvellePartie() {
        // Logique pour créer une nouvelle partie
        // Afficher le premier écran de salle
    }

    public void sauvergarderPartie() {
        // Logique pour sauvegarder les données, les attributs
    }

    public void chargerSauvegarde() {
        // Logique pour charger une sauvegarde
        // Afficher l'écran de la salle en fonction de l'état sauvegardé
    }

    public void changerDeSalle(int choix) {
        // Logique pour changer de salle
        switch (choix) {
            case 0: // Ecran Accueil Partie
                ecranAccueil = new EcranAccueil(this);
                fenetre.setContentPane(ecranAccueil);
                break;
            case 1: // Salon
                ecranSalon = new EcranSalon(this);
                fenetre.setContentPane(ecranSalon);
                break;
            case 2: // Cuisine
                ecranCuisine = new EcranCuisine(this);
                fenetre.setContentPane(ecranCuisine);
                break;
            case 3: // jardin
                ecranJardin = new EcranJardin(this);
                fenetre.setContentPane(ecranJardin);
                break;
            case 4: // Salle de bain
                ecranSalleBain = new EcranSalleBain(this);
                fenetre.setContentPane(ecranSalleBain);
                break;
        }
        // Mettre à jour l'écran de la salle en fonction de la nouvelle salle
    }

    // Autres méthodes et logique de contrôle
}
