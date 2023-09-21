package vue;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlleur.TamagotchiControleur;

public class EcranRiviere extends JPanel {
    private TamagotchiControleur controleur;

    public EcranRiviere(TamagotchiControleur controleur) {
        this.controleur = controleur;
        this.setLayout(null);

        // Initialisation des boutons

        // Quitter
        JButton btnQuitter = new JButton("Quitter");
        btnQuitter.setBounds(350, 20, 120, 40);
        this.add(btnQuitter);
        // --> ouvrir menu quitter pour save

        // Bouton se laver
        JButton btnLaver = new JButton("Se laver");
        btnLaver.setBounds(300, 300, 120, 40);
        this.add(btnLaver);

        // Bouton aller dans la forêt
        JButton btnForet = new JButton("Forêt");
        btnForet.setBounds(70, 250, 120, 40);
        this.add(btnForet);

        // gestion des écouteurs

        // Aller à la foret
        btnForet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.actualiserContenuFenetre(2);
            }
        });

        // Laver
        btnLaver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.laverTama();
            }
        });
    }

}