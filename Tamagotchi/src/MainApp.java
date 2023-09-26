import vue.TamagotchiFrame;
import controlleur.TamagotchiControleur;

public class MainApp {
    public static void main(String[] args) throws Exception {
        TamagotchiFrame tamagotchiFrame = new TamagotchiFrame(); // Instanciation d'une fenêtre
        TamagotchiControleur controleur = new TamagotchiControleur(tamagotchiFrame); // Instanciation d'un
        // controlleur
        // reliant le modèle
        // à la vue

        tamagotchiFrame.display();
    }
}
