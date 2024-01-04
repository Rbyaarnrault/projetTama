package modele;

import java.util.ArrayList;
import java.util.List;

public class SalleForet extends Salle {

    public SalleForet() {
        nom = "foret";
    }

    @Override
    public List<String> getActionsDisponibles() {
        // Retourne la liste des actions disponibles dans la forêt
        List<String> actions = new ArrayList<>();
        actions.add("Jouer");
        return actions;
    }

    @Override
    public String effectuerAction(String action, Tamagotchi tamagotchi) {
        switch (action) {
            case "Jouer":
                tamagotchi.jouer();
                return "Le Tamagotchi a joué dans la forêt.";
            default:
                return "Action non reconnue.";
        }
    }

}