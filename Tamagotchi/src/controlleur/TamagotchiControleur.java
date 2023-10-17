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
    private TamagotchiFrame fenetre;
    private EcranJeu panJeu;
    private Partie partie;
    private Timer timer;

    public TamagotchiControleur(TamagotchiFrame fen) {
        // Initialisation de la fenêtre JFrame
        fenetre = fen;
        changerEcran(0); // Initialisation du panel d'accueil
        fenetre.afficher();
    }

    public void creerNouvellePartie(String n, String t) {
        // Logique pour créer une nouvelle partie
        Tamagotchi tama = new Tamagotchi(n, t); // Création du tamagotchi en récupérant le contenu des JTextField
        partie = new Partie(tama);

        // RAJOUTER DEUX 0 AU TIMER, ENLEVE POUR LA DEMO PLUS RAPIDE (432000= 7min env.)
        timer = new Timer(43200 / 6, new ActionListener() { // Correspond à 1/100% de 12h
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mise à jour des constantes selon le timer

                // A MODIFIER SELON LES ENVIES
                partie.getTamagotchi().setVie(getVieTama() - 5);
                partie.getTamagotchi().setFaim(getNourritureTama() - 5);
                partie.getTamagotchi().setSommeil(getLoisirTama() - 5);
                partie.getTamagotchi().setHygiene(getHygieneTama() - 1);
                partie.getTamagotchi().setLoisir(getLoisirTama() - 2);
                panJeu.getPanelBarres().actualiserConstantes(getVieTama(), getSommeilTama(), getNourritureTama(),
                        getHygieneTama(), getLoisirTama());

                // Condition tamagotchi mort -> Fin de partie
                if (partie.getTamagotchi().getVie() <= 0) {
                    JOptionPane.showMessageDialog(fenetre,
                            " Votre tamagotchi " + partie.getTamagotchi().getNom() + " est mort.  Fin de partie!");

                    // Arret du timer
                    timer.stop();

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
        partie.sauvergarder();
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
        partie.getTamagotchi().manger();
        // ligne pour agir sur la vue exemple : JProgressBar barFaim.setFill(n)
    }

    public void dormirTama() {
        // Logique pour la gestion du sommeil/dodo du Tama
        partie.getTamagotchi().dormir();
        // ligne pour agir sur la vue ...
    }

    public void jouerTama() {
        // Logique pour la gestion du loisir/jeu du Tama
        partie.getTamagotchi().jouer();
        // ligne pour agir sur la vue
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
}