package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;

import controlleur.TamagotchiControleur;

public class EcranDeveloppeur extends JPanel {

    private TamagotchiControleur contr;

    public EcranDeveloppeur(TamagotchiControleur contr) {
        this.contr = contr;
        this.setLayout(null);

        JSlider slider = new JSlider(1, 100, 50);
        this.add(slider);

        JButton boutonJeu = new JButton("Retour au Jeu");
        boutonJeu.setBounds(460, 500, 120, 40);
        this.add(boutonJeu);

        boutonJeu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contr.changerEcran("developpeur");
            }
        });
    }
}
