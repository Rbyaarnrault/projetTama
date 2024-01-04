package vue;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

import javax.swing.JPanel;

import controlleur.TamagotchiControleur;
import util.EcranActualisable;

public class EcranJeu extends JPanel implements EcranActualisable {

    private TamagotchiControleur controleur;
    private PanelProgressBar panBarres;
    private PanelInfos panInfos;
    protected JButton btnDeveloppeur, btnQuitter, btnManger, btnLaver, btnJouer,
            btnDormir, btnRecycler, btnRecharger, btnMaj, btnBlague, boutonGauche, boutonDroite;
    private PanelImgTama panTama;

    public EcranJeu(TamagotchiControleur controleur) {
        this.controleur = controleur;
        this.setLayout(null);

        initialiserPanels();
    }

    protected void initialiserPanels() {
        // Initialisation des barres d'attributs

        panBarres = new PanelProgressBar();
        panInfos = new PanelInfos();

        creerPanelComposants();
        placerComposants();

        this.add(panBarres);
        this.add(panInfos);

    }

    protected void initialiserPanelTamagotchi() {

        panTama = new PanelImgTama(controleur);
        this.add(panTama);
    }

    protected void creerPanelComposants() {

        // Boutons
        btnDeveloppeur = new JButton("Mode Développeur");
        btnQuitter = new JButton("Quitter");

        // Actions
        btnManger = new JButton("Manger");
        btnLaver = new JButton("Laver");
        btnDormir = new JButton("Dormir");
        btnJouer = new JButton("Jouer");

        // Boutons du robot
        btnRecycler = new JButton("Recycler");
        btnRecharger = new JButton("Recharger");
        btnMaj = new JButton("Mise à jour");
        btnBlague = new JButton("Blague");

        // Créer les boutons triangles de navigation intersalles
        boutonGauche = new BoutonTriangle(BoutonTriangle.Direction.GAUCHE);
        boutonDroite = new BoutonTriangle(BoutonTriangle.Direction.DROITE);

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
        boutonGauche.addActionListener(new ActionListener() {
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

        // Place et ajoute les boutons triangles à votre écran
        boutonGauche.setBounds(330, 400, 50, 50);
        boutonDroite.setBounds(410, 400, 50, 50);
        this.add(boutonGauche);
        this.add(boutonDroite);

        // Liste de mes boutons Actions
        List<JButton> boutonsActions = new ArrayList<JButton>();
        boutonsActions.add(btnManger);
        boutonsActions.add(btnDormir);
        boutonsActions.add(btnJouer);
        boutonsActions.add(btnLaver);

        for (JButton bouton : boutonsActions) {
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
        panBarres.actualiserConstantes(controleur.getPartie().getTamagotchi());
        initialiserPanelTamagotchi();
        panTama.actualiserImageTama();
    }

}
