package vue;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlleur.TamagotchiControleur;

public class EcranJeu extends JPanel {
    private TamagotchiControleur controleur;
    private JPanel panComposants;
    private PanelProgressBar panBarres;

    public EcranJeu(TamagotchiControleur controleur) {
        this.controleur = controleur;
        this.setLayout(null);

        this.add(initialiserPanelProgressBar());
        this.add(creerPanelComposants());
    }

    private PanelProgressBar initialiserPanelProgressBar() {
        // Initialisation des barres d'attributs ??????
        int a = controleur.getVieTama();
        int b = controleur.getNourritureTama();
        int c = controleur.getSommeilTama();
        int d = controleur.getHygieneTama();
        int e = controleur.getLoisirTama();
        return panBarres = new PanelProgressBar(a, b, c, d, e);
    }

    private JPanel creerPanelComposants() {

        panComposants = new JPanel();
        // -----Initialisation des boutons-----
        // Quitter
        JButton btnQuitter = new JButton("Quitter");
        btnQuitter.setBounds(400, 260, 120, 40);
        panComposants.add(btnQuitter);
        // --> ouvrir menu quitter pour save

        // Bouton Manger
        JButton btnManger = new JButton("Manger");
        btnManger.setBounds(200, 40, 120, 40);
        panComposants.add(btnManger);

        // Bouton Jouer
        JButton btnJouer = new JButton("Jouer");
        btnJouer.setBounds(200, 100, 120, 40);
        panComposants.add(btnJouer);

        // Bouton aller dans la tente
        JButton btnTente = new JButton("Tente");
        btnTente.setBounds(200, 160, 120, 40);
        panComposants.add(btnTente);

        // Bouton aller à la rivière
        JButton btnRiviere = new JButton("Rivière");
        btnRiviere.setBounds(200, 220, 120, 40);
        panComposants.add(btnRiviere);

        // -----Gestion des écouteurs-----
        // Aller à la rivière
        btnRiviere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // Manger
        btnManger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.nourrirTama();
                ;
            }
        });

        // Aller à la tente
        btnTente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // Jouer
        btnJouer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.jouerTama();
            }
        });

        // Quitter
        btnQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.changerEcran(3);
            }
        });

        return panComposants;
    }

    // ------
    // Getter du panel des JprogressBar
    public PanelProgressBar getPanelBarres() {
        return panBarres;
    }
}