package vue;

import javax.swing.JFrame;

import modele.Tamagotchi;

public class TamagotchiFrame extends JFrame {
    private Tamagotchi tamagotchi;

    public TamagotchiFrame(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;

        setTitle("Tamagotchi Simulator");
        setSize(600, 400); // Définit la taille de la fenêtre de l'application
        setResizable(false); // Empêche la modification des dimensions de la fenêtre de l'application
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Arrête l'instance de l'application en fermant la fenêtre
        setLocationRelativeTo(null); // Place la fenêtre au centre de l'écran de l'ordinateur
    }

    public void display() {
        setVisible(true); // Rend visible la fenêtre;
    }
}
