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

    public EcranFeu(TamagotchiControleur contr) {
        this.controleur = contr;
        this.setLayout(null);

        this.add(initialiserPanelProgressBar());
        creerPanelComposants();
    }

    private PanelProgressBar initialiserPanelProgressBar() {
        // Initialisation des barres d'attributs
        return panBarres = new PanelProgressBar();
    }

    private void creerPanelComposants() {

        // -----Initialisation des boutons-----

        // Bouton Mode développeur
        JButton btnDeveloppeur = new JButton("Mode Développeur");
        btnDeveloppeur.setBounds(460, 300, 100, 60);
        this.add(btnDeveloppeur);

        // Quitter
        JButton btnQuitter = new JButton("Quitter");
        btnQuitter.setBounds(400, 260, 120, 40);
        this.add(btnQuitter);
        // --> ouvrir menu quitter pour save

        // Bouton Manger
        JButton btnManger = new JButton("Manger");
        btnManger.setBounds(200, 40, 120, 40);
        this.add(btnManger);

        // Bouton aller dans la foret
        JButton btnForet = new JButton("Forêt");
        btnForet.setBounds(200, 100, 120, 40);
        this.add(btnForet);

        // Bouton aller dans la tente
        JButton btnTente = new JButton("Tente");
        btnTente.setBounds(200, 160, 120, 40);
        this.add(btnTente);

        // Bouton aller à la rivière
        JButton btnRiviere = new JButton("Rivière");
        btnRiviere.setBounds(200, 220, 120, 40);
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

    // Méthode d'actualisation du PanelProgressBar
    @Override
    public void actualiserBarresAvecAttributs() {
        panBarres.actualiserConstantes(controleur.getPartie().getTamagotchi());
    }
}
