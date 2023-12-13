package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

import controlleur.TamagotchiControleur;
import util.EcranActualisable;

public class EcranTente extends JPanel implements EcranActualisable {

    private TamagotchiControleur controleur;
    private PanelProgressBar panBarres;

    public EcranTente(TamagotchiControleur contr) {
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

        // Bouton Dormir
        JButton btnDormir = new JButton("Dormir");
        btnDormir.setBounds(180, 140, 80, 30);
        this.add(btnDormir);

        // Bouton Feu
        JButton btnFeu = new JButton("Feu");
        btnFeu.setBounds(180, 220, 80, 30);
        this.add(btnFeu);

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

        // Déclencer l'action "Dormir"
        btnDormir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.dormirTama();
            }
        });

        // Aller au feu
        btnFeu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.changerEcran("feu");
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
