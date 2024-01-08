package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonSauvegarde extends JButton {

    public BoutonSauvegarde(String nomSauvegarde, Image imageTamagotchi) {
        this.setText(nomSauvegarde);

        // Redimensionner l'image
        Image scaledImage = imageTamagotchi.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        // Configurer l'icône du bouton avec l'image redimensionnée
        this.setIcon(new ImageIcon(scaledImage));

        // Ajouter un ActionListener pour afficher sur le bouton
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Charger la sauvegarde : " + nomSauvegarde);
            }
        });
    }
}
