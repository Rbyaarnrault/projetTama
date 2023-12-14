package vue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TamagotchiFrame extends JFrame {

    public TamagotchiFrame() {

        setTitle("Tamagotchi Simulator");
        setSize(700, 500);
        setResizable(false); // Empêche la modification des dimensions de la fenêtre de l'application
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Arrête l'instance de l'application en fermant la fenêtre
        setLocationRelativeTo(null); // Place la fenêtre au centre de l'écran de l'ordinateur
    }

    public void afficher() {
        setVisible(true); // Rend visible la fenêtre;
    }

    public void actualiser(JPanel pan) {
        this.setContentPane(pan);
        this.revalidate();
    }

}
