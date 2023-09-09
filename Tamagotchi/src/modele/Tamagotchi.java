package modele;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Tamagotchi {

    private String name;
    private String type;

    public Tamagotchi(String name, String type) { // Instancie un objet tamagotchi par son nom
        this.name = name;
        if ((type.equals("Chien")) || (type.equals("Chat")) || (type.equals("Robot"))) {
            this.type = type;
        } else {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Vous devez choisir le type de Tamagotchi !");
        }
    }
}
