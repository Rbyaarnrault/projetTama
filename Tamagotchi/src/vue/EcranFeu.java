package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controlleur.TamagotchiControleur;
import util.EcranActualisable;

public class EcranFeu extends JPanel implements EcranActualisable {

    private TamagotchiControleur controleur;
    private PanelProgressBar panBarres;
    private PanelInfos panInfos;

    public EcranFeu(TamagotchiControleur contr) {
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

        // -----Initialisation des boutons-----

        // Bouton Mode développeur
        JButton btnDeveloppeur = new JButton("Mode Développeur");
        btnDeveloppeur.setBounds(520, 400, 160, 20);
        this.add(btnDeveloppeur);

        // Quitter
        JButton btnQuitter = new JButton("Quitter");
        btnQuitter.setBounds(500, 360, 120, 30);
        this.add(btnQuitter);
        // --> ouvrir menu quitter pour save

        // Bouton Manger
        JButton btnManger = new JButton("Manger");
        btnManger.setBounds(280, 240, 80, 30);
        this.add(btnManger);

        // Bouton aller dans la foret
        JButton btnForet = new JButton("Forêt");
        btnForet.setBounds(280, 320, 80, 30);
        this.add(btnForet);

        // Bouton aller dans la tente
        JButton btnTente = new JButton("Tente");
        btnTente.setBounds(280, 360, 80, 30);
        this.add(btnTente);

        // Bouton aller à la rivière
        JButton btnRiviere = new JButton("Rivière");
        btnRiviere.setBounds(280, 400, 80, 30);
        this.add(btnRiviere);

        // -----Gestion des écouteurs-----
        // Aller au mode développeur
        btnDeveloppeur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.changerEcran("developpeur");
            }
        });

        // Aller à la rivière
        btnRiviere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.changerEcran("riviere");
            }
        });

        // Manger
        btnManger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.nourrirTama();
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

    // Getter du panel des JprogressBar
    public PanelInfos getPanelInfos() {
        return panInfos;
    }

    // Méthode d'actualisation du PanelProgressBar
    @Override
    public void actualiserComposantsAvecAttributs() {
        panInfos.actualiserInfos(controleur.getPartie());
        panBarres.actualiserConstantes(controleur.getPartie().getTamagotchi());
    }

}
