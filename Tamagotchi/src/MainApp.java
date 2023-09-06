import controlleur.TamagotchiControlleur;
import modele.Tamagotchi;
import vue.TamagotchiFrame;

public class MainApp {
    public static void main(String[] args) throws Exception {
        Tamagotchi tamagotchi = new Tamagotchi("Tama"); // Instanciation d'un tamagotchi
        TamagotchiFrame tamagotchiFrame = new TamagotchiFrame(tamagotchi); // Instanciation d'une fenêtre
        TamagotchiControlleur tamagotchiControlleur = new TamagotchiControlleur(tamagotchi, null); // Instanciation d'un
                                                                                                   // controlleur
                                                                                                   // reliant le modèle
                                                                                                   // à la vue

        tamagotchiFrame.display();
    }
}
