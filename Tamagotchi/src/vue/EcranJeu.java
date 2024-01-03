package vue;

import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlleur.TamagotchiControleur;
import util.EcranActualisable;

public class EcranJeu extends JPanel implements EcranActualisable {

    private TamagotchiControleur controleur;
    private PanelProgressBar panBarres;
    private PanelInfos panInfos;
    protected JButton btnDeveloppeur, btnQuitter, btnManger, btnForet, btnTente, btnRiviere, btnFeu, btnLaver, btnJouer,
            btnDormir, btnRecycler, btnRecharger, btnMaj, btnBlague;;

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

        // Lieux
        btnForet = new JButton("Forêt");
        btnTente = new JButton("Tente");
        btnRiviere = new JButton("Rivière");
        btnFeu = new JButton("Feu");
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

        // LIEUX

        // Aller à la rivière
        btnRiviere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.changerEcran("riviere");
            }
        });

        // Aller à la tente
        btnTente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.changerEcran("tente");
            }
        });

        // Aller à la foret
        btnForet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.changerEcran("foret");
            }
        });

        // Aller au feu de camp
        btnFeu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.changerEcran("feu");
            }
        });

        // ACTIONS

        // Manger
        btnManger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.nourrirTama();
            }
        });

        btnDormir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.dormirTama();
            }
        });

        btnJouer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.jouerTama();
            }
        });

        btnLaver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.laverTama();
            }
        });

    }

    protected void placerComposants() { // ?????????????????

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
