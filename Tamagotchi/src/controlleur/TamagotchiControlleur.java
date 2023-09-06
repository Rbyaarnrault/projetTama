package controlleur;

import modele.Tamagotchi;
import vue.TamagotchiView;

public class TamagotchiControlleur {

    private Tamagotchi tamagotchi;
    private TamagotchiView tamagotchiView;

    public TamagotchiControlleur(Tamagotchi tamagotchi, TamagotchiView tamagotchiView) {
        this.tamagotchi = tamagotchi;
        this.tamagotchiView = tamagotchiView;
    }
}
