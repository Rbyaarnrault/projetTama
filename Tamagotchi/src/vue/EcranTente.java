package vue;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

import controlleur.TamagotchiControleur;
import modele.Robot;

public class EcranTente extends EcranJeu {

    private Image img;
    private TamagotchiControleur contr;

    public EcranTente(TamagotchiControleur contr) {
        super(contr);
        this.contr = contr;
        this.setLayout(null);
        this.img = new ImageIcon("Tamagotchi/src/ressources/img/tente.png").getImage();
    }

    protected void placerComposants() {
        btnDeveloppeur.setBounds(520, 440, 160, 20);
        this.add(btnDeveloppeur);
        btnQuitter.setBounds(560, 400, 120, 30);
        this.add(btnQuitter);
        // BTN Actions
        if (!(contr.getPartie().getTamagotchi() instanceof Robot)) {
            btnDormir.setBounds(580, 255, 80, 30);
            this.add(btnDormir);
        } else {
            // Si robot
            btnRecharger.setBounds(580, 190, 80, 30);
            this.add(btnRecharger);
            btnBlague.setBounds(580, 225, 80, 30);
            this.add(btnBlague);
            btnLibererMemoire.setBounds(580, 260, 80, 30);
            this.add(btnLibererMemoire);
        }
        boutonHaut.setBounds(330, 250, 50, 50);
        this.add(boutonHaut);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, getWidth(), getHeight(), (ImageObserver) this);
        }
    }

}
