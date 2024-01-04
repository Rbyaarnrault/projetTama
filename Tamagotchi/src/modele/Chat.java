package modele;

import javax.swing.ImageIcon;

public class Chat extends Tamagotchi {

    public Chat(String name) {
        super(name);
        // A MODIFIER POUR BONNE IMAGE
        cheminImage = "";
        setImage(new ImageIcon(cheminImage).getImage());
    }

    @Override
    protected StrategieConstantes initialiserStrategie() {
        return new StrategieChat();
    }
}
