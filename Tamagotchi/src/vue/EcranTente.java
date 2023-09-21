package vue;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlleur.TamagotchiControleur;

public class EcranTente extends JPanel {
    private TamagotchiControleur controleur;

    public EcranTente(TamagotchiControleur controleur) {
        this.controleur = controleur;
        this.setLayout(null);

        // Initialisation des boutons

        // Quitter
        JButton btnQuitter = new JButton("Quitter");
        btnQuitter.setBounds(350, 20, 120, 40);
        this.add(btnQuitter);
        // --> ouvrir menu quitter pour save

        // Bouton Dormir
        JButton btnDormir = new JButton("Dormir");
        btnDormir.setBounds(300, 300, 120, 40);
        this.add(btnDormir);

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

        // Dormir
        btnDormir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.dormirTama();
                ;
            }
        });
    }
}
