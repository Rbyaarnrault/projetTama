package modele;

import java.util.ArrayList;
import java.util.List;

public class SalleFeu extends Salle {

    public SalleFeu() {
        nom = "feu";
    }

    @Override
    public List<String> getActionsDisponibles() {
        // Retourne la liste des actions disponibles dans la forêt
        List<String> actions = new ArrayList<>();
        actions.add("Manger");
        return actions;
    }

    @Override
    public String effectuerAction(String action, Tamagotchi tamagotchi) {
        switch (action) {
            case "Manger":
                tamagotchi.manger();
                return "Le Tamagotchi a mangé dans la forêt.";
            default:
                return "Action non reconnue.";
        }
    }

}