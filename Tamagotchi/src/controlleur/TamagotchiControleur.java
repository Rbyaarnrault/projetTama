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

        panDev = new EcranDeveloppeur(this);

        changerEcran("accueil"); // Initialisation du panel d'accueil
        fenetre.afficher();
    }

    public void creerNouvellePartie(String n, String t) {
        // Logique pour créer une nouvelle partie
        Tamagotchi tama = choisirTamagotchi(n, t);
        partie = new Partie(tama);

        // Choix et placement des boutons/Actions selon le tama
        for (EcranActualisable ecran : ecrans) {
            ecran.initialiserComposants();
        }

        changerEcran("foret");
        demarrerTimers(); // Va démarrer tous les timers et l'initialisation de tous les attributs et
                          // constantes sur chaque écran
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

        // Obtenir une condition météo sans attendre le delai du timer
        partie.getMeteo().obtenirNouvelleConditionMeteo();

        // timer qui va actualiser les attributs du tamagotchi
        timerDecrementation = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour décrémenter les attributs du Tamagotchi
                partie.getTamagotchi().actualisationDecrementationConstantes(partie.getVitesseTimerDecrement());
            }
        });
        // timer qui va actualiser toutes les secondes les barres d'attributs
        timerActualisation = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualiserEcrans(); // Actualise les ecrans toutes les secondes
                partie.getTamagotchi().calculDureeVie(); // Recalcule l'attribut vie en fonction de l'évolution des
                                                         // autres attributs

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

        // Démarrez les timers dont les 2 derniers avec un léger décalage pour éviter
        // les conflits
        timerDecrementation.start();
        timerActualisation.start();
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

        JOptionPane.showMessageDialog(new JFrame(),
                "La sauvegarde a bien été effectuée ! \n Vous allez revenir à l'accueil");

        try {
            relancerApplication();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public void chargerPartie(String nomFichier) {
        // Logique pour charger une sauvegarde contenue dans le fichier à cet
        // emplacement
        partie = Partie.charger(nomFichier);
        if (partie != null) {
            System.out.println("Sauvegarde " + nomFichier + " chargée !");

            // Récupération de VitesseTimerDecrement
            panDev.getSlider().setValue(partie.getVitesseTimerDecrement());

            // Arrivée dans la foret comme pour la création d'une nouvelle partie
            demarrerTimers(); // redémarrage de tous les timers
            changerEcran("foret");

        }
    }

    public void supprimerSauvegarde() {
        // Logique pour supprimer une sauvegarde

    }

    // --------Choix de l'écran----------
    public void changerEcran(String choix) {
        JPanel pan = new JPanel(); // Nouveau JPanel temporaire qui va être affecté de l'écran voulu
        Boolean condition = true; // Sert pour l'EcranSauvegardes

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
                EcranSauvegardes ecranS = new EcranSauvegardes(this);

                // Si le repertoire de sauvegarde est vide
                if (ecranS.getRepertoireSauvegarde() == null || ecranS.getRepertoireSauvegarde().length == 0) {
                    condition = false;
                    JOptionPane.showMessageDialog(new JFrame(), " Le répertoire de sauvegarde est vide/inconnu !");
                    System.out.println("Répertoire de sauvegarde  vide/inconnu");
                } else {
                    condition = true;
                    ecranS.initialiserSauvegardes();
                    pan = ecranS;
                }
                break;

            default:
                System.out.println("nom de l'écran voulu inconnu");
                break;
        }
        if (choix != "quitter" && choix != "developpeur") {
            panActif = choix; // Dernier écran actif appelé avant le mode développeur
        }
        if (condition == true) {
            // Si c'est durant la partie
            if (partie != null) {

                // Si le tama est vivant, changement d'écran possible
                if (partie.getTamagotchi().estMort() == false) {
                    fenetre.actualiser(pan);

                } else { // Si le tama est mort, plus aucune action possible

                    // Afficher un message informant de la mort et redémarrer l'application
                    int res = JOptionPane.showOptionDialog(new JFrame(),
                            "Votre Tamagotchi est mort. Game Over. \n    L'application va redémarrer",
                            "Game Over", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                            new Object[] { "OK" },
                            "OK");
                    if ((res == JOptionPane.YES_OPTION) || (res == JOptionPane.CLOSED_OPTION)) {
                        try {
                            relancerApplication();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                // Si la partie n'a pas encore été crée, pas de condition pour changer d'écran
                fenetre.actualiser(pan);
            }
        }

    }

    // -----Action sur le modèle---------

    // Permet de se déplacer sur la salle de gauche de la salleActuelle en
    // récupérant son nom qui est paramètre de la fonction setSalleActuelle
    public void deplacerVersLaGauche() {
        String s = partie.getSalleActuelle().getSalleGauche().getNomSalle();
        if (!(partie.getTamagotchi() instanceof Robot)) { // SI pas un robot
            partie.setSalleActuelle(s);
        } else {
            if (s.equals("riviere")) { // Le robot ne peut pas aller dans la rivière.
                JOptionPane.showMessageDialog(new JFrame("Avertissement"),
                        "Le robot ne peut pas aller dans la rivière.");
            } else {
                partie.setSalleActuelle(s);
            }
        }

        changerEcran(s);
    }

    // IDEM pour la droite
    public void deplacerVersLaDroite() {
        String s = partie.getSalleActuelle().getSalleDroite().getNomSalle();
        partie.setSalleActuelle(s);
        changerEcran(s);
    }

    public void effectuerActionTama(String action) {
        if (partie.getTamagotchi().estMort() == false) {
            // SI le tamagotchi est vivant
            partie.getSalleActuelle().effectuerAction(action, partie.getTamagotchi());

        } else {
            // Si le tama est mort, plus aucune action possible
            // Afficher un message informant de la mort et redémarrer l'application
            int choix = JOptionPane.showOptionDialog(new JFrame(),
                    "Votre Tamagotchi est mort. Game Over. \n    L'application va redémarrer",
                    "Game Over", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                    new Object[] { "OK" },
                    "OK");
            if ((choix == JOptionPane.YES_OPTION) || (choix == JOptionPane.CLOSED_OPTION)) {
                try {
                    relancerApplication();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // AJOUTER LES METHODES SPECIFIQUE DU ROBOT

    // Robot
    public void rechargerRobot() {
        // Logique pour la gestion de la recharge du robot
        if (partie.getTamagotchi() instanceof Robot) {
            ((Robot) partie.getTamagotchi()).recharger();
        } else {
            // METTRE UN JOPTION PANE ?
            System.out.println("Ce type de tamagotchi ne peut pas se recharger.");
        }
    }

    public void libererMemoireRobot() {
        // Logique pour la gestion des mises à jour du robot
        if (partie.getTamagotchi() instanceof Robot) {
            ((Robot) partie.getTamagotchi()).libererMemoire();
        } else {
            // METTRE UN JOPTION PANE ?
            System.out.println("Ce type de tamagotchi ne peut pas libérer de la mémoire.");
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

    public double getVieTama() {
        return partie.getTamagotchi().getVie();
    }

    public double getNourritureTama() {
        return partie.getTamagotchi().getFaim();
    }

    public double getSommeilTama() {
        return partie.getTamagotchi().getSommeil();
    }

    public double getHygieneTama() {
        return partie.getTamagotchi().getHygiene();
    }

    public double getLoisirTama() {
        return partie.getTamagotchi().getLoisir();
    }

    public JFrame getFrame() {
        return fenetre;
    }

    // -----Restart du controleur-----

    public void relancerApplication() throws Exception {
        String[] args = {};
        MainApp.main(args);
    }
}