package modele;

public class Poussin extends Tamagotchi {
    public Poussin(String name) {
        super(name);
        this.strategie = new StrategiePoussin();
    }

    @Override
    protected StrategieConstantes initialiserStrategie() {
        return new StrategiePoussin();
    }
}
