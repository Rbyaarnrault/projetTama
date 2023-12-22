package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import controlleur.TamagotchiControleur;
import util.EcranActualisable;

public class EcranRiviere extends EcranJeu implements EcranActualisable {

    private TamagotchiControleur controleur;
    private PanelProgressBar panBarres;
    private PanelInfos panInfos;

    public EcranRiviere(TamagotchiControleur contr) {
        this.controleur = contr;
        this.setLayout(null);

        initialiserPanels();
    }

    private void initialiserPanels() {
        // Initialisation des barres d'attributs
        panBarres = new PanelProgressBar();
        panInfos = new PanelInfos();
        creerPanelComposants();

        this.add(panBarres);
        this.add(panInfos);
    }

    private void creerPanelComposants() {

        // Bouton Manger
        JButton btnManger = new JButton("Manger");
        btnManger.setBounds(280, 240, 80, 30);
        this.add(btnManger);

        // Bouton Jouer
        JButton btnJouer = new JButton("Jouer");
        btnJouer.setBounds(280, 280, 80, 30);
        this.add(btnJouer);

        // Bouton Se laver
        JButton btnLaver = new JButton("Laver");
        btnLaver.setBounds(180, 360, 80, 30);
        this.add(btnLaver);

        // Bouton Feu
        JButton btnFeu = new JButton("Feu");
        btnFeu.setBounds(280, 360, 80, 30);
        this.add(btnFeu);

        // Bouton Foret
        JButton btnForet = new JButton("Foret");
        btnForet.setBounds(280, 400, 80, 30);
        this.add(btnForet);

        // Bouton Mode développeur
        JButton btnDeveloppeur = new JButton("Mode Développeur");
        btnDeveloppeur.setBounds(520, 400, 160, 20);
        this.add(btnDeveloppeur);

        // Quitter
        JButton btnQuitter = new JButton("Quitter");
        btnQuitter.setBounds(500, 360, 120, 30);
        this.add(btnQuitter);
        // --> ouvrir menu quitter pour save

        // -----Gestion des écouteurs-----

        // Aller au feu
        btnFeu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.changerEcran("feu");
            }
        });

        // Aller à la forêt
        btnForet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.changerEcran("foret");
            }
        });

        // Déclencer l'action "Manger"
        btnManger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.nourrirTama();
            }
        });

        // Déclencer l'action "Jouer"
        btnJouer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.jouerTama();
            }
        });

        // Déclencher l'action "Se Laver"
        btnLaver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.laverTama();
            }
        });

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
    }

    // ------
    // Getter du panel des JprogressBar
    public PanelProgressBar getPanelBarres() {
        return panBarres;
    }

    // Méthode d'actualisation du PanelProgressBar
    @Override
    public void actualiserComposantsAvecAttributs() {
        panInfos.actualiserInfos(controleur.getPartie());
        panBarres.actualiserConstantes(controleur.getPartie().getTamagotchi());
    }
}
