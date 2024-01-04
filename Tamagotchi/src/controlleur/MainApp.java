package controlleur;

import vue.TamagotchiFrame;

public class MainApp {

    private static TamagotchiFrame tamagotchiFrame;

    public static void main(String[] args) throws Exception {
        if (tamagotchiFrame != null) {
            // Ferme une éventuelle précédente fenêtre ouverte de l'application
            tamagotchiFrame.dispose();
        }
        tamagotchiFrame = new TamagotchiFrame(); // Instanciation d'une fenêtre

        // Instanciation d'un controlleur reliant le modèle à la vue
        new TamagotchiControleur(tamagotchiFrame);
        tamagotchiFrame.afficher();
    }
}
