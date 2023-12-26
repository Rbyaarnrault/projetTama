package modele;

public class Poussin extends Tamagotchi {
    public Poussin(String name) {
        super(name);
    }

    @Override
    protected StrategieConstantes initialiserStrategie() {
        return new StrategiePoussin();
    }
}
