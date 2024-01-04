package modele;

import javax.swing.ImageIcon;

public class Poussin extends Tamagotchi {
    public Poussin(String name) {
        super(name);
        // A MODIFIER POUR BONNE IMAGE
        setImage(new ImageIcon("").getImage());
    }

    @Override
    protected StrategieConstantes initialiserStrategie() {
        return new StrategiePoussin();
    }
}
