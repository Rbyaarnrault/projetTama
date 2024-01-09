package vue;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;

import controlleur.TamagotchiControleur;
import modele.Robot;

public class EcranForet extends EcranJeu {

    private Image img;
    private TamagotchiControleur contr;

    public EcranForet(TamagotchiControleur contr) {
        super(contr);
        this.contr = contr;
        this.setLayout(null);
        this.img = new ImageIcon("Tamagotchi/src/ressources/img/imgF1.jpg").getImage();
        // super.initialiserPanels();
    }

    protected void placerComposants() {
        btnDeveloppeur.setBounds(520, 440, 160, 20);
        this.add(btnDeveloppeur);
        btnQuitter.setBounds(560, 400, 120, 30);
        this.add(btnQuitter);
        // BTN Actions
        if (!(contr.getPartie().getTamagotchi() instanceof Robot)) {
            // Actions pour un tama différent du robot
            btnJouer.setBounds(580, 255, 80, 30);
            this.add(btnJouer);
            boutonHaut.setBounds(330, 280, 50, 50);
        } else {
            // Si robot
            btnBlague.setBounds(580, 255, 80, 30);
            this.add(btnBlague);
            btnLibererMemoire.setBounds(580, 255, 80, 30);
            this.add(btnLibererMemoire);
        }
        // Déplacements
        this.add(boutonHaut);
        boutonBas.setBounds(330, 400, 50, 50);
        this.add(boutonBas);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, getWidth(), getHeight(), (ImageObserver) this);
        }
    }

}
