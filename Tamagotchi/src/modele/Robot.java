package modele;

public class Robot extends Tamagotchi {

    public Robot(String name) {
        super(name);
    }

    @Override
    protected StrategieConstantes initialiserStrategie() {
        return new StrategieRobot();
    }
}
