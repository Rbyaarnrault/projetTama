package vue;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import controlleur.TamagotchiControleur;
import modele.Tamagotchi;

public class EcranForet extends EcranJeu {

    private TamagotchiControleur controleur;
    private PanelProgressBar panBarres;
    private PanelInfos panInfos;
    private Image img;

    public EcranForet(TamagotchiControleur contr) {
        super(contr);
        this.controleur = contr;
        this.setLayout(null);
        this.img = new ImageIcon("Tamagotchi/src/ressources/img/imgForet.jpg").getImage();

        initialiserPanels();
    }

    protected void initialiserPanels() {
        // Initialisation des barres d'attributs
        panBarres = new PanelProgressBar();
        panInfos = new PanelInfos();
        creerPanelComposants();

        this.add(panBarres);
        this.add(panInfos);
    }

    protected void creerPanelComposants() {

        // -----Initialisation des boutons-----

        // Bouton Jouer
        JButton btnJouer = new JButton("Jouer");
        btnJouer.setBounds(280, 240, 80, 30);
        this.add(btnJouer);

        // Bouton Mode développeur
        JButton btnDeveloppeur = new JButton("Mode Développeur");
        btnDeveloppeur.setBounds(520, 400, 160, 20);
        this.add(btnDeveloppeur);

        // Quitter
        JButton btnQuitter = new JButton("Quitter");
        btnQuitter.setBounds(500, 360, 120, 30);
        this.add(btnQuitter);
        // --> ouvrir menu quitter pour save

        // Bouton Feu
        JButton btnFeu = new JButton("Feu");
        btnFeu.setBounds(280, 320, 80, 30);
        this.add(btnFeu);

        // Bouton Rivière
        JButton btnRiviere = new JButton("Riviere");
        btnRiviere.setBounds(280, 360, 80, 30);
        this.add(btnRiviere);

        // -----Gestion des écouteurs-----

        // Déclencer l'action "Jouer"
        btnJouer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.jouerTama();
            }
        });

        // Aller au feu
        btnFeu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.changerEcran("feu");
            }
        });

        // Aller à la rivière
        btnRiviere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.changerEcran("riviere");
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, getWidth(), getHeight(), (ImageObserver) this);
        }
    }

}
