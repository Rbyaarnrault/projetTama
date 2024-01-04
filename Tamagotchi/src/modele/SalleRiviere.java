package modele;

import java.util.ArrayList;
import java.util.List;

public class SalleRiviere extends Salle {

    @Override
    public List<String> getActionsDisponibles() {
        // Retourne la liste des actions disponibles dans la forêt
        List<String> actions = new ArrayList<>();
        actions.add("Laver");
        actions.add("Jouer");
        return actions;
    }

    @Override
    public String effectuerAction(String action, Tamagotchi tamagotchi) {
        switch (action) {
            case "Laver":
                tamagotchi.laver();
                return "Le Tamagotchi s'est lavé dans la rivière.";
            case "Jouer":
                tamagotchi.jouer();
                return "Le Tamagotchi a joué avec l'eau de la rivière.";
            default:
                return "Action non reconnue.";
        }
    }

}
