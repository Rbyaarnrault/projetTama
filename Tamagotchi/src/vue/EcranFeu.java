package vue;

import javax.swing.ImageIcon;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import controlleur.TamagotchiControleur;

public class EcranFeu extends EcranJeu {

    private Image img;

    public EcranFeu(TamagotchiControleur contr) {
        super(contr);
        this.setLayout(null);
        this.img = new ImageIcon("Tamagotchi/src/ressources/img/imgFe3.jpg").getImage();
        super.initialiserPanels();
    }

    protected void placerComposants() {
        btnDeveloppeur.setBounds(520, 440, 160, 20);
        this.add(btnDeveloppeur);
        btnQuitter.setBounds(560, 400, 120, 30);
        this.add(btnQuitter);
        // BTN Lieux
        btnForet.setBounds(320, 220, 80, 30);
        this.add(btnForet);
        btnTente.setBounds(480, 330, 80, 30);
        this.add(btnTente);
        // BTN Actions
        btnManger.setBounds(320, 420, 80, 30);
        this.add(btnManger);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, getWidth(), getHeight(), (ImageObserver) this);
        }
    }
}
