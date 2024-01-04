package vue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import controlleur.TamagotchiControleur;

public class EcranQuitter extends JPanel {
    private TamagotchiControleur controleur;

    private JButton btnSave;
    private JButton btnAnnuler;

    private java.awt.Image img;

    public EcranQuitter(TamagotchiControleur controleur) {
        this.controleur = controleur;
        setLayout(null); // Utilisation d'un layout null pour positionner manuellement les composants
        this.img = new ImageIcon("Tamagotchi/src/ressources/img/sortie.png").getImage();
        creerComposants();
        placerComposants();
    }

    private void creerComposants() {
        // Bouton de Sauvegarde
        btnSave = new JButton("Sauvegarder et quitter");

        // Bouton de retour
        btnAnnuler = new JButton("Annuler");

        // Initialisation des écouteurs
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.sauvergarderPartie();
            }
        });

        btnAnnuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.changerEcran(controleur.getPanelActif());
            }
        });
    }

    private void placerComposants() {
        // Positionnement manuel des boutons
        btnSave.setBounds(240, 250, 180, 30); // x, y, largeur, hauteur
        btnAnnuler.setBounds(300, 380, 80, 30);

        // Ajout des boutons au panel
        add(btnSave);
        add(btnAnnuler);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, getWidth(), getHeight(), (ImageObserver) this);
        }
    }
}
