package modele;

public class Chien extends Tamagotchi {

    public Chien(String nom) {
        super(nom);
        this.strategie = new StrategieChien();
    }

    @Override
    protected StrategieConstantes initialiserStrategie() {
        return new StrategieChien();
    }

}
