package modele;

import javax.swing.ImageIcon;

public class Chien extends Tamagotchi {

    public Chien(String nom) {
        super(nom);
        // A MODIFIER POUR BONNE IMAGE
        imageTamagotchi = new ImageIcon("").getImage();
    }

    @Override
    protected StrategieConstantes initialiserStrategie() {
        return new StrategieChien();
    }

}
