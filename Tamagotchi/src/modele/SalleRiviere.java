package modele;

import java.util.ArrayList;
import java.util.List;

public class SalleRiviere extends Salle {

    public SalleRiviere() {
        nom = "riviere";
    }

    @Override
    public List<String> getActionsDisponibles() {
        // Retourne la liste des actions disponibles dans la forêt
        List<String> actions = new ArrayList<>();
        actions.add("Laver");
        actions.add("Jouer");
        actions.add("Mourir");
        return actions;
    }

    @Override
    // Permet de savoir quelles actions sont possibles et d'éliminer les
    // potentielles non autorisées
    public String effectuerAction(String action, Tamagotchi tamagotchi) {
        switch (action) {
            case "Laver":
                tamagotchi.laver();
                return "Le Tamagotchi s'est lavé dans la rivière.";
            case "Jouer":
                tamagotchi.jouer();
                return "Le Tamagotchi a joué dans l'eau de la rivière.";
            case "Mourir":
                tamagotchi.mourir();
                return "Le Tamagotchi s'est noyé dans la rivière.";
            default:
                return "Action impossible ici/inconnue.";
        }
    }

}
