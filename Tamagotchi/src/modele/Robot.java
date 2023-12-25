package modele;

public class Robot extends Tamagotchi {

    public Robot(String name) {
        super(name);
        this.strategie = new StrategieRobot();
    }

    @Override
    protected StrategieConstantes initialiserStrategie() {
        return new StrategieRobot();
    }
}
