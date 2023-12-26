package modele;

public class Chat extends Tamagotchi {

    public Chat(String name) {
        super(name);
    }

    @Override
    protected StrategieConstantes initialiserStrategie() {
        return new StrategieChat();
    }
}
