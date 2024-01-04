package modele;

import javax.swing.ImageIcon;

public class Poussin extends Tamagotchi {
    public Poussin(String name) {
        super(name);
        // A MODIFIER POUR BONNE IMAGE
        cheminImage = "Tamagotchi/src/ressources/img/Poussin2.png";
        setImage(new ImageIcon(cheminImage).getImage());
    }

    @Override
    protected StrategieConstantes initialiserStrategie() {
        return new StrategiePoussin();
    }
}
