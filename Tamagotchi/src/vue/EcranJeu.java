package vue;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controlleur.TamagotchiControleur;
//import javafx.scene.paint.Color;
import util.EcranActualisable;

public class EcranJeu extends JPanel implements EcranActualisable {

    private TamagotchiControleur controleur;
    private PanelProgressBar panBarres;
    private PanelInfos panInfos;
    protected BoutonColore btnDeveloppeur, btnQuitter, btnManger, btnLaver, btnJouer,
            btnDormir, btnRecycler, btnRecharger, btnMaj, btnBlague;
    protected JButton boutonGauche, boutonDroite, boutonHaut, boutonBas;

    private PanelImgTama panTama;

    // Définition d'une couleur en hexadécimal
    String hexColor = "#C2794C"; // marron clair
    String hexColor2 = "#5E271E"; // marron foncé
    Color clair = Color.decode(hexColor);
    Color fonce = Color.decode(hexColor2);

    public EcranJeu(TamagotchiControleur controleur) {
        this.controleur = controleur;
        this.setLayout(null);

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.put("Button.background", clair);
            UIManager.put("Button.foreground", fonce);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        initialiserPanels();
    }

    protected void initialiserPanels() {
        // Initialisation de l'affichage des attributs

        panBarres = new PanelProgressBar();
        panInfos = new PanelInfos();

        creerPanelComposants();
        placerComposants();

        this.add(panBarres);
        this.add(panInfos);
    }

    protected void initialiserPanelTamagotchi() {
        // Panel qui affiche l'image du tamagotchi
        panTama = new PanelImgTama(controleur);
        this.add(panTama);
    }

    protected void creerPanelComposants() {

        // Boutons
        btnDeveloppeur = new BoutonColore("Mode Développeur");
        btnQuitter = new BoutonColore("Quitter");

        // Actions
        btnManger = new BoutonColore("Manger");
        btnLaver = new BoutonColore("Laver");
        btnDormir = new BoutonColore("Dormir");
        btnJouer = new BoutonColore("Jouer");

        // Boutons du robot
        btnRecycler = new BoutonColore("Recycler");
        btnRecharger = new BoutonColore("Recharger");
        btnMaj = new BoutonColore("Mise à jour");
        btnBlague = new BoutonColore("Blague");

        // Créer les boutons triangles de navigation intersalles
        boutonDroite = new BoutonTriangle(BoutonTriangle.Direction.DROITE);
        // Créer les boutons triangles de navigation intersalles
        boutonHaut = new BoutonTriangle(BoutonTriangle.Direction.HAUT);
        boutonBas = new BoutonTriangle(BoutonTriangle.Direction.BAS);

        // -----Gestion des écouteurs-----
        // Aller au mode développeur
        btnDeveloppeur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.changerEcran("developpeur");
            }
        });

        // Quitter
        btnQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.changerEcran("quitter");
            }
        });

        // Lieux

        // AJout des listeners sur les boutons triangles (de Direction)
        boutonHaut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Permet de faire l'action seulement si une salle est accessible à gauche
                if (controleur.getPartie().getSalleActuelle().getSalleGauche() != null) {
                    // Déplacer vers la salle de gauche
                    controleur.deplacerVersLaGauche();
                }
            }
        });

        boutonDroite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Permet de faire l'action seulement si une salle est accessible à droite
                if (controleur.getPartie().getSalleActuelle().getSalleDroite() != null) {
                    // Déplacer vers la salle de gauche
                    controleur.deplacerVersLaDroite();
                }
            }
        });

        boutonBas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Permet de faire l'action seulement si une salle est accessible à droite
                if (controleur.getPartie().getSalleActuelle().getSalleDroite() != null) {
                    // Déplacer vers la salle de gauche
                    controleur.deplacerVersLaDroite(); // C'est juste un nom de méthode, ça ne définit pas le
                                                       // comportement qui ici définit la prochaine parmi une des deux
                                                       // salles adjacentes
                }
            }
        });

        // Liste de mes boutons Actions
        List<BoutonColore> boutonsActions = new ArrayList<BoutonColore>();
        boutonsActions.add(btnManger);
        boutonsActions.add(btnDormir);
        boutonsActions.add(btnJouer);
        boutonsActions.add(btnLaver);

        for (BoutonColore bouton : boutonsActions) {
            bouton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Appel de la fonction avec le texte de l'action
                    try {
                        controleur.effectuerActionTama(bouton.getText());
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            });
        }
    }

    protected void placerComposants() { // Méthode redéfinit dans les sous classes

    }

    // ------
    // Getter du panel des JprogressBar
    public PanelProgressBar getPanelBarres() {
        return panBarres;
    }

    // Getter du panel des JprogressBar
    public PanelInfos getPanelInfos() {
        return panInfos;
    }

    public PanelImgTama getPanelImgTama() {
        return panTama;
    }

    // Méthode d'actualisation du PanelProgressBar
    @Override
    public void actualiserComposantsAvecAttributs() {
        panInfos.actualiserInfos(controleur.getPartie());
        panBarres.actualiserBarresSelonConstantes(controleur.getPartie().getTamagotchi());
        initialiserPanelTamagotchi();
        panTama.actualiserImageTama();
    }

}
