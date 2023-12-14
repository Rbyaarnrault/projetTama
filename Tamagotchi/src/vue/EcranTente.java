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
    private PanelInfos panInfos;

    public EcranTente(TamagotchiControleur contr) {
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

        // Bouton Dormir
        JButton btnDormir = new JButton("Dormir");
        btnDormir.setBounds(280, 240, 80, 30);
        this.add(btnDormir);

        // Bouton Feu
        JButton btnFeu = new JButton("Feu");
        btnFeu.setBounds(280, 320, 80, 30);
        this.add(btnFeu);

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
    public void actualiserComposantsAvecAttributs() {
        panInfos.actualiserInfos(controleur.getPartie());
        panBarres.actualiserConstantes(controleur.getPartie().getTamagotchi());
    }
}
