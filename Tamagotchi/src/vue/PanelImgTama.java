package vue;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlleur.TamagotchiControleur;

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
        this.imgIcon = new ImageIcon(controleur.getPartie().getTamagotchi().getImage());
        this.imgTama = new JLabel(imgIcon);

        this.add(imgTama);
    }

}
