import vue.TamagotchiFrame;
import controlleur.TamagotchiControleur;

public class MainApp {
    public static void main(String[] args) throws Exception {
        TamagotchiFrame tamagotchiFrame = new TamagotchiFrame(); // Instanciation d'une fenêtre

        // Instanciation d'un controlleur reliant le modèle à la vue
        new TamagotchiControleur(tamagotchiFrame);
        tamagotchiFrame.afficher();
    }
}
