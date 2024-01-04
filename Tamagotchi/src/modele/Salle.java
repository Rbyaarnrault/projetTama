package modele;

import java.util.List;

public abstract class Salle {
    public abstract List<String> getActionsDisponibles();

    public abstract String effectuerAction(String action, Tamagotchi tamagotchi);
}