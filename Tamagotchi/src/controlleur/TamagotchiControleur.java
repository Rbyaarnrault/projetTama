package controlleur;

import javax.swing.JOptionPane;
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
    private EcranJeu panJeu;
    private Partie partie;

    public TamagotchiControleur(TamagotchiFrame fen) {
        // Initialisation de la fenêtre JFrame
        fenetre = fen;
        changerEcran(0); // Initialisation du panel d'accueil
        fenetre.display();
    }

    public void creerNouvellePartie(String n, String t) {
        // Logique pour créer une nouvelle partie
        tamagotchi = new Tamagotchi(n, t); // Création du tamagotchi en récupérant le contenu des JTextField
        partie = new Partie(tamagotchi);

        // RAJOUTER DEUX 0 AU TIMER, ENLEVE POUR LA DEMO PLUS RAPIDE (432000= 7min env.)
        Timer timer = new Timer(43200 / 6, new ActionListener() { // Correspond à 1/100% de 12h
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mise à jour des constantes selon le timer

                // A MODIFIER SELON LES ENVIES
                tamagotchi.setVie(getVieTama() - 5);
                tamagotchi.setFaim(getNourritureTama() - 5);
                tamagotchi.setSommeil(getLoisirTama() - 5);
                tamagotchi.setHygiene(getHygieneTama() - 1);
                tamagotchi.setLoisir(getLoisirTama() - 2);
                panJeu.getPanelBarres().actualiserConstantes(getVieTama(), getSommeilTama(), getNourritureTama(),
                        getHygieneTama(), getLoisirTama());

                // Condition tamagotchi mort -> Fin de partie
                if (tamagotchi.getVie() <= 0) {
                    JOptionPane.showMessageDialog(fenetre,
                            " Votre tamagotchi " + tamagotchi.getNom() + " est mort.  Fin de partie!");
                    // Revenir à l'écran d'accueil
                    changerEcran(0);

                    // Rajouter le fait de sauvegarder la partie et la "fermer" sinon message erreur
                    // s'affiche sur l'accueil
                }
            }

            /// VOIR SI COMPATIBLE AVEC LA SAUVEGARDE ET SI CA NE VA PAS POSER DE PROBLEME
            /// ET COUPER LE TIMER QUAND ON JOUE PAS. LES CONSTANTES DOIVENT QUAND MEME
            /// BAISSER VOIR POUR UTILISER ET COMPARER AU TEMPS MACHINE SINON ?
        });

        // Démarrez le minuteur
        timer.start();

        // Afficher le salon à l'écran
        changerEcran(2);
    }

    public void sauvergarderPartie() {
        partie.sauvergarderPartie();
        // remettre accueil
        changerEcran(0);
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
    public void changerEcran(int choix) {
        JPanel pan = new JPanel();

        switch (choix) {
            case 0: // Ecran Accueil
                pan = new EcranAccueil(this);
                break;
            case 1: // CréationPartie
                pan = new EcranCreation(this);
                break;
            case 2: // Ecran Jeu
                panJeu = new EcranJeu(this);
                pan = panJeu;
                break;
            case 3: // Ecran Quitter
                pan = new EcranQuitter(this);
                break;
        }
        fenetre.actualiser(pan); // Affectation du Jpanel à la fenetre
    }

    // -----Action sur le modèle---------

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