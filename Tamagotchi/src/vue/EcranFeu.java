package vue;

import javax.swing.ImageIcon;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import controlleur.TamagotchiControleur;
import modele.Robot;

public class EcranFeu extends EcranJeu {

    private Image img;
    private TamagotchiControleur contr;

    public EcranFeu(TamagotchiControleur contr) {
        super(contr);
        this.contr = contr;
        this.setLayout(null);
        this.img = new ImageIcon("Tamagotchi/src/ressources/img/imgFe3.jpg").getImage();
    }

    protected void placerComposants() {
        btnDeveloppeur.setBounds(520, 440, 160, 20);
        this.add(btnDeveloppeur);
        btnQuitter.setBounds(560, 400, 120, 30);
        this.add(btnQuitter);
        // BTN Actions
        if (!(contr.getPartie().getTamagotchi() instanceof Robot)) {
            // Actions pour un tama différent du robot
            btnManger.setBounds(580, 255, 80, 30);
            this.add(btnManger);

        } else {
            // Si robot
            btnBlague.setBounds(580, 255, 80, 30);
            this.add(btnBlague);
            btnLibererMemoire.setBounds(580, 280, 80, 30);
            this.add(btnLibererMemoire);
        }
        // Déplacement
        boutonHaut.setBounds(330, 220, 50, 50);
        this.add(boutonHaut);
        boutonDroite.setBounds(440, 320, 50, 50);
        this.add(boutonDroite);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, getWidth(), getHeight(), (ImageObserver) this);
        }
    }
}
