package vue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlleur.TamagotchiControleur;

public class EcranQuitter extends JPanel {
    private TamagotchiControleur controleur;
    private JPanel panComposants;

    public EcranQuitter(TamagotchiControleur controleur) {
        this.controleur = controleur;
        this.setLayout(null);
        this.add(creerPanelComposants());
    }

    private JPanel creerPanelComposants() {

        panComposants = new JPanel();

        // Bouton de Sauvegarde
        JButton btnSave = new JButton("Sauvegarder");
        btnSave.setBounds(150, 20, 120, 40);
        panComposants.add(btnSave);

        // Bouton de retour
        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.setBounds(150, 100, 120, 40);
        panComposants.add(btnAnnuler);

        // Initialisation des écouteurs
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.sauvergarderPartie();
                JOptionPane.showMessageDialog(new JFrame(), "La sauvegarde a bien été effectuée !");
            }
        });

        btnAnnuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Permet de revenir à l'écran de jeu
                controleur.changerEcran(3);
            }
        });

        return panComposants;
    }
}