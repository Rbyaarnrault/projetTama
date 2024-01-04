package vue;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

import controlleur.TamagotchiControleur;

public class EcranTente extends EcranJeu {

    private Image img;

    public EcranTente(TamagotchiControleur contr) {
        super(contr);
        this.setLayout(null);
        this.img = new ImageIcon("Tamagotchi/src/ressources/img/tente.png").getImage();
        super.initialiserPanels();
    }

    protected void placerComposants() {
        btnDeveloppeur.setBounds(520, 440, 160, 20);
        this.add(btnDeveloppeur);
        btnQuitter.setBounds(560, 400, 120, 30);
        this.add(btnQuitter);
        // BTN Actions
        btnDormir.setBounds(580, 255, 80, 30);
        this.add(btnDormir);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, getWidth(), getHeight(), (ImageObserver) this);
        }
    }

}
