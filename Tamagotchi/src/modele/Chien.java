package modele;

import javax.swing.ImageIcon;

public class Chien extends Tamagotchi {

    public Chien(String nom) {
        super(nom);
        // A MODIFIER POUR BONNE IMAGE
        setImage(new ImageIcon("Tamagotchi/src/ressources/img/Chien2.png").getImage());
    }

    @Override
    protected StrategieConstantes initialiserStrategie() {
        return new StrategieChien();
    }

}
