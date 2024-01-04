package modele;

import java.util.ArrayList;
import java.util.List;

public class SalleTente extends Salle {

    @Override
    public List<String> getActionsDisponibles() {
        // Retourne la liste des actions disponibles dans la forêt
        List<String> actions = new ArrayList<>();
        actions.add("Dormir");
        return actions;
    }

    @Override
    public String effectuerAction(String action, Tamagotchi tamagotchi) {
        switch (action) {
            case "Dormir":
                tamagotchi.jouer();
                return "Le Tamagotchi a dormi dans la tente.";
            default:
                return "Action non reconnue.";
        }
    }

}
