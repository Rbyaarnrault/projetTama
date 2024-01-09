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
            case "Manger":
                tamagotchi.manger();
                return "Le Tamagotchi a mangé au coin du feu.";

            case "Mourir":
                tamagotchi.mourir();
                return "Le Tamagotchi est mort au coin du feu.";
            case "Libérer de la mémoire":
                tamagotchi.libererMemoire();
                return " Le tamagotchi a libéré de la mémoire au coin du feu.";
            case "Blaguer":
                tamagotchi.blaguer();
                return " Le tamagotchi fait des blagues au coin du feu.";

            default:
                return "Action impossible ici/inconnue.";
        }
    }

}