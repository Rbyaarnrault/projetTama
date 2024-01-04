package modele;

import javax.swing.ImageIcon;

public class Chien extends Tamagotchi {

    public Chien(String nom) {
        super(nom);
        // A MODIFIER POUR BONNE IMAGE
        cheminImage = "Tamagotchi/src/ressources/img/Chien2.png";
        setImage(new ImageIcon(cheminImage).getImage());
    }

    @Override
    protected StrategieConstantes initialiserStrategie() {
        return new StrategieChien();
    }

}
