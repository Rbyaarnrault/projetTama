package controlleur;

import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modele.Chat;
import modele.Chien;
import modele.Partie;
import modele.Poussin;
import modele.Robot;
import modele.Tamagotchi;
import util.EcranActualisable;
import vue.*;

public class TamagotchiControleur {
    private TamagotchiFrame fenetre;
    private EcranForet panForet;
    private EcranRiviere panRiviere;
    private EcranFeu panFeu;
    private EcranTente panTente;
    private EcranDeveloppeur panDev;
    private Partie partie;
    private Timer timerActualisation, timerDecrementation, timerMeteo;
    private int vitesseTimerDecr = 1; // Valeur par défault si non modifiée
    private List<EcranActualisable> ecrans;
    private String panActif;

    public TamagotchiControleur(TamagotchiFrame fen) {
        // Initialisation de la fenêtre JFrame
        this.fenetre = fen;
        panForet = new EcranForet(this);
        panRiviere = new EcranRiviere(this);
        panFeu = new EcranFeu(this);
        panTente = new EcranTente(this);
        ecrans = new ArrayList<>();
        ecrans.add(panFeu); // Ces 4 écrans serons actualisés fréquemment
        ecrans.add(panForet);
        ecrans.add(panRiviere);
        ecrans.add(panTente);

        panDev = new EcranDeveloppeur(vitesseTimerDecr, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Récupération de la vitesse du timer depuis l'écran ModeDéveloppeur, par
                // défault sinon
                vitesseTimerDecr = panDev.getVitesseTimer();

                // Maj du délai du timer de décrémentation en fonction de la vitesse choisie
                timerDecrementation.setDelay(5000 / vitesseTimerDecr);
                changerEcran(getPanelActif()); // Rappelle le dernier écran actif
            }
        });

        changerEcran("accueil"); // Initialisation du panel d'accueil
        fenetre.afficher();
    }

    public void creerNouvellePartie(String n, String t) {
        // Logique pour créer une nouvelle partie
        Tamagotchi tama = choisirTamagotchi(n, t);
        partie = new Partie(tama);

        demarrerTimers(); // Va démarrer tous les timers et l'initialisation de tous les attributs et
                          // constantes sur chaque écran
        changerEcran("foret");
    }

    // Méthode qui instancie le bon type de tamagotchi selon l'espèce choisie
    private Tamagotchi choisirTamagotchi(String nom, String espece) {
        switch (espece) {
            case "Chien":
                return new Chien(nom);
            case "Chat":
                return new Chat(nom);
            case "Robot":
                return new Robot(nom);
            case "Poussin":
                return new Poussin(nom);
            // Gestion d'erreur:
            default:
                throw new IllegalArgumentException("Espèce non reconnue : " + espece);
        }
    }

    private void demarrerTimers() {
        // Création des timer avec une action à effectuer à chaque intervalle

        // timer qui va actualiser toutes les secondes les barres d'attributs
        timerActualisation = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualiserEcrans(); // Actualise les ecrans toutes les secondes
                partie.getTamagotchi().ajouterSecondeDuree(); // Ajoute la duree de vie au tamagotchi
            }
        });

        // timer qui va décrémenter les attributs du tamagotchi
        timerDecrementation = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour décrémenter les attributs du Tamagotchi
                partie.getTamagotchi().decrementer();
            }
        });

        // timer qui va modifier à terme la météo
        timerMeteo = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour décrémenter les attributs du Tamagotchi
                partie.getMeteo().obtenirNouvelleConditionMeteo();
            }
        });

        // Démarrez les timers
        timerActualisation.start();
        timerDecrementation.start();
        timerMeteo.start();
    }

    // Méthode pour actualiser tous les écrans
    private void actualiserEcrans() {
        if (ecrans != null) {
            for (EcranActualisable ecran : ecrans) {
                ecran.actualiserComposantsAvecAttributs();
            }
        }
    }

    // -----Gestion de la sauvegarde-----
    public void sauvergarderPartie() {
        // Logique pour sauvegarder une partie en cours
        partie.sauvergarder();
        JOptionPane.showMessageDialog(new JFrame(), "La sauvegarde a bien été effectuée !");

        // remettre accueil
        changerEcran("accueil");
    }

    public void chargerPartie(String nomFichier) {
        // Logique pour charger une sauvegarde contenue dans le fichier à cet
        // emplacement
        partie = Partie.charger(nomFichier);
        if (partie != null) {
            System.out.println("Sauvegarde " + nomFichier + " chargée !");
            demarrerTimers();
            changerEcran("foret");

        }
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
                fenetre.setTitle("Feu de camp");
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
                pan = panDev;
                break;
            case "sauvegardes": // Ecran de choix de sauvegardes
                fenetre.setTitle("Choix d'une sauvegarde");
                pan = new EcranSauvegardes(this);
                break;
        }
        if (choix != "developpeur") {
            panActif = choix; // Dernier écran actif appelé avant le mode développeur
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

    // AJOUTER LES METHODES SPECIFIQUE DU ROBOT

    // Robot

    public void recyclerRobot() {
        // Logique pour la gestion du mode recyclage du robot
        if (partie.getTamagotchi() instanceof Robot) {
            ((Robot) partie.getTamagotchi()).recycler();
        } else {
            // METTRE UN JOPTION PANE ?
            System.out.println("Ce type de tamagotchi ne peut pas se recycler.");
        }
    }

    public void rechargerRobot() {
        // Logique pour la gestion de la recharge du robot
        if (partie.getTamagotchi() instanceof Robot) {
            ((Robot) partie.getTamagotchi()).recharger();
        } else {
            // METTRE UN JOPTION PANE ?
            System.out.println("Ce type de tamagotchi ne peut pas se recharger.");
        }
    }

    public void majRobot() {
        // Logique pour la gestion des mises à jour du robot
        if (partie.getTamagotchi() instanceof Robot) {
            ((Robot) partie.getTamagotchi()).maj();
        } else {
            // METTRE UN JOPTION PANE ?
            System.out.println("Ce type de tamagotchi ne peut pas se mettre à jour.");
        }
    }

    public void blagueRobot() {
        // Logique pour la gestion des blagues du robot
        if (partie.getTamagotchi() instanceof Robot) {
            ((Robot) partie.getTamagotchi()).blaguer();
        } else {
            // METTRE UN JOPTION PANE ?
            System.out.println("Ce type de tamagotchi ne peut pas faire de blagues.");
        }
    }

    // CREER UN GETROBOT SPECIFIQUE PLUTOT QUE GETTAMAGOTCHI ?

    // -----Getters-----
    public Partie getPartie() {
        return partie;
    }

    public String getPanelActif() {
        return panActif;
    }

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