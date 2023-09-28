package vue;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlleur.TamagotchiControleur;

public class EcranForet extends JPanel {
    private TamagotchiControleur controleur;

    public EcranForet(TamagotchiControleur controleur) {
        this.controleur = controleur;
        this.setLayout(null);

        // Initialisation des barres d'attributs ??????
        int a = controleur.getVieTama();
        int b = controleur.getNourritureTama();
        int c = controleur.getSommeilTama();
        int d = controleur.getHygieneTama();
        int e = controleur.getLoisirTama();
        PanelProgressBar panBarre = new PanelProgressBar(a, b, c, d, e);
        this.add(panBarre);

        // -----Initialisation des boutons-----
        // Quitter
        JButton btnQuitter = new JButton("Quitter");
        btnQuitter.setBounds(150, 20, 120, 40);
        this.add(btnQuitter);
        // --> ouvrir menu quitter pour save

        // Bouton Manger
        JButton btnManger = new JButton("Manger");
        btnManger.setBounds(150, 150, 120, 40);
        this.add(btnManger);

        // Bouton Jouer
        JButton btnJouer = new JButton("Jouer");
        btnJouer.setBounds(220, 300, 120, 40);
        this.add(btnJouer);

        // Bouton aller dans la tente
        JButton btnTente = new JButton("Tente");
        btnTente.setBounds(300, 200, 120, 40);
        this.add(btnTente);

        // Bouton aller à la rivière
        JButton btnRiviere = new JButton("Rivière");
        btnRiviere.setBounds(30, 50, 120, 40);
        this.add(btnRiviere);

        // -----Gestion des écouteurs-----
        // Aller à la rivière
        btnRiviere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.actualiserContenuFenetre(5);
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
                controleur.actualiserContenuFenetre(4);
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
                controleur.quitterPartie();
            }
        });

    }
}
