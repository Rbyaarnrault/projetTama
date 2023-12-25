package modele;

public class Chat extends Tamagotchi {

    public Chat(String name) {
        super(name);
        this.strategie = new StrategieChat();
    }

    @Override
    protected StrategieConstantes initialiserStrategie() {
        return new StrategieChat();
    }
}
