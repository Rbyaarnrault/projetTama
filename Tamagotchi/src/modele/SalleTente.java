package modele;

import java.util.ArrayList;
import java.util.List;

public class SalleTente extends Salle {

    public SalleTente() {
        nom = "tente";
    }

    @Override
    public List<String> getActionsDisponibles() {
        // Retourne la liste des actions disponibles dans la forêt
        List<String> actions = new ArrayList<>();
        actions.add("Dormir");
        actions.add("Mourir");
        actions.add("Blaguer");
        actions.add("Recharger");
        return actions;
    }

    @Override
    // Permet de savoir quelles actions sont possibles et d'éliminer les
    // potentielles non autorisées
    public String effectuerAction(String action, Tamagotchi tamagotchi) {
        switch (action) {
            case "Dormir":
                tamagotchi.jouer();
                return "Le Tamagotchi a dormi dans la tente.";
            case "Mourir":
                tamagotchi.mourir();
                return "Le Tamagotchi est mort dans la tente.";
            case "Blaguer":
                // (Tamagotchi.Robot) tamagotchi.blaguer();
                return "Le Tamagotchi est mort dans la tente.";
            case "Recharger":
                // (Robot)tamagotchi.recharger();
                return "Le Tamagotchi est mort dans la tente.";

            default:
                return "Action impossible ici/inconnue.";
        }
    }

}
