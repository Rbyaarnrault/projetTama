package controlleur;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modele.Partie;
import modele.Tamagotchi;
import vue.*;

public class TamagotchiControleur {
    private Tamagotchi tamagotchi;
    private TamagotchiFrame fenetre;
    private EcranCreation ecranCreation;
    private EcranAccueil ecranAccueil;
    private EcranSalon ecranSalon;
    private EcranCuisine ecranCuisine;
    private EcranJardin ecranJardin;
    private EcranSalleBain ecranSalleBain;
    private Partie partie;

    public TamagotchiControleur(TamagotchiFrame fen) {
        // Initialisation de la fenêtre JFrame
        fenetre = fen;
        changerDeSalle(0); // Initialisation du panel d'accueil
        fenetre.display();
    }

    public void creerNouvellePartie(String n, String t) {
        // Logique pour créer une nouvelle partie
        tamagotchi = new Tamagotchi(n, t); // Création du tamagotchi en récupérant le contenu des JTextField
        partie = new Partie(tamagotchi);

        changerDeSalle(2); // Afficher le salon à l'écran
    }

    public void sauvergarderPartie() {
        // Logique pour sauvegarder les données, les attributs

        // partie exportée ?
    }

    public void chargerSauvegarde() {
        // Logique pour charger une sauvegarde
        // Afficher l'écran de la salle en fonction de l'état sauvegardé
    }

    public void changerDeSalle(int choix) {
        // Logique pour changer de salle
        switch (choix) {
            case 0: // Ecran Accueil
                ecranAccueil = new EcranAccueil(this);
                fenetre.setContentPane(ecranAccueil);
                fenetre.revalidate();
                break;
            case 1: // CréationPartie
                ecranCreation = new EcranCreation(this);
                fenetre.setContentPane(ecranCreation);
                fenetre.revalidate();
                break;
            case 2: // Salon
                ecranSalon = new EcranSalon(this);
                fenetre.setContentPane(ecranSalon);
                fenetre.revalidate();
                break;
            case 3: // Cuisine
                ecranCuisine = new EcranCuisine(this);
                fenetre.setContentPane(ecranCuisine);
                fenetre.revalidate();
                break;
            case 4: // jardin
                ecranJardin = new EcranJardin(this);
                fenetre.setContentPane(ecranJardin);
                fenetre.revalidate();
                break;
            case 5: // Salle de bain
                ecranSalleBain = new EcranSalleBain(this);
                fenetre.setContentPane(ecranSalleBain);
                fenetre.revalidate();
                break;
        }

    }

}
