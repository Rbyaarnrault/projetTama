package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

import controlleur.TamagotchiControleur;
import util.EcranActualisable;

public class EcranRiviere extends JPanel implements EcranActualisable {

    private TamagotchiControleur controleur;
    private PanelProgressBar panBarres;

    public EcranRiviere(TamagotchiControleur contr) {
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

        // Bouton Manger
        JButton btnManger = new JButton("Manger");
        btnManger.setBounds(180, 140, 80, 30);
        this.add(btnManger);

        // Bouton Jouer
        JButton btnJouer = new JButton("Jouer");
        btnJouer.setBounds(180, 180, 80, 30);
        this.add(btnJouer);

        // Bouton Feu
        JButton btnFeu = new JButton("Feu");
        btnFeu.setBounds(180, 260, 80, 30);
        this.add(btnFeu);

        // Bouton Foret
        JButton btnForet = new JButton("Foret");
        btnForet.setBounds(180, 300, 80, 30);
        this.add(btnForet);

        // Bouton Mode développeur
        JButton btnDeveloppeur = new JButton("Mode Développeur");
        btnDeveloppeur.setBounds(420, 300, 160, 20);
        this.add(btnDeveloppeur);

        // Quitter
        JButton btnQuitter = new JButton("Quitter");
        btnQuitter.setBounds(400, 260, 120, 30);
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
    public void actualiserBarresAvecAttributs() {
        panBarres.actualiserConstantes(controleur.getPartie().getTamagotchi());
    }
}
