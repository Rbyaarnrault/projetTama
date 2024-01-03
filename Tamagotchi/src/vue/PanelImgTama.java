package vue;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelImgTama extends JPanel {

    private JLabel imgTama;
    private ImageIcon imgIcon;

    public PanelImgTama() {

        this.setOpaque(false);
        this.imgIcon = new ImageIcon("Tamagotchi/src/ressources/img/Chien2.png");
        this.imgTama = new JLabel(imgIcon);

        this.add(imgTama);

        // Arrangement en grille (col, lig, hgap, vgap)
        this.setBounds(15, 190, 240, 260);
    }

}
