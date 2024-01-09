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
        actions.add("Mourir");
        actions.add("Libérer de la mémoire");
        actions.add("Blaguer");
        return actions;
    }

    @Override
    // Permet de savoir quelles actions sont possibles et d'éliminer les
    // potentielles non autorisées
    public String effectuerAction(String action, Tamagotchi tamagotchi) {
        switch (action) {
            case "Jouer":
                tamagotchi.jouer();
                return "Le Tamagotchi a joué dans la forêt.";
            case "Mourir":
                tamagotchi.mourir();
                return "Le Tamagotchi est mort dans la forêt.";
            case "Blaguer":
                tamagotchi.blaguer();
                return "Le Tamagotchi fait des blagues dans la forêt.";
            case "Libérer de la mémoire":
                tamagotchi.libererMemoire();
                return "Le Tamagotchi libère de la mémoire dans la forêt.";

            default:
                return "Action impossible ici/inconnue.";
        }
    }

}