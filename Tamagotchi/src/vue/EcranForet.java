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

        // Initialisation des boutons

        // Bouton Manger
        JButton btnManger = new JButton("Manger");
        btnManger.setBounds(150, 150, 120, 40);
        this.add(btnManger);

        // Bouton aller dans la tente
        JButton btnTente = new JButton("Tente");
        btnTente.setBounds(300, 200, 120, 40);
        this.add(btnTente);

        // Bouton aller à la rivière
        JButton btnRiviere = new JButton("Rivière");
        btnRiviere.setBounds(30, 50, 120, 40);
        this.add(btnRiviere);

        // gestion des écouteurs

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

        // Aller à la rivière
        btnRiviere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.actualiserContenuFenetre(5);
            }
        });

    }
}
