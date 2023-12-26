package modele;

public class Chien extends Tamagotchi {

    public Chien(String nom) {
        super(nom);
    }

    @Override
    protected StrategieConstantes initialiserStrategie() {
        return new StrategieChien();
    }

}
