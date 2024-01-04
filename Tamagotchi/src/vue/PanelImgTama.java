package vue;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlleur.TamagotchiControleur;
import modele.Tamagotchi;

public class PanelImgTama extends JPanel {

    private JLabel imgTama;
    private ImageIcon imgIcon;
    private TamagotchiControleur controleur;

    public PanelImgTama(TamagotchiControleur controleur) {

        this.setOpaque(false);
        this.controleur = controleur;

        // Arrangement en grille (col, lig, hgap, vgap)
        this.setBounds(15, 190, 240, 260);
    }

    public void actualiserImageTama() {
        Tamagotchi tamagotchi = controleur.getPartie().getTamagotchi();

        if (tamagotchi != null) {
            Image image = tamagotchi.getImage();

            if (image != null) {
                this.imgIcon = new ImageIcon(image);
                this.imgTama = new JLabel(imgIcon);

                this.removeAll(); // Supprimer les composants précédents avant d'ajouter le nouveau
                this.add(imgTama);
            } else {
                System.out.println("L'image du Tamagotchi est null.");
            }
        } else {
            System.out.println("Le Tamagotchi dans la Partie est null.");
        }
    }

}
