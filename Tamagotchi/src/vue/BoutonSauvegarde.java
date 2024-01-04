package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonSauvegarde extends JButton {

    private String nomSauvegarde;

    public BoutonSauvegarde(String nomSauvegarde, Image imageTamagotchi) {
        this.nomSauvegarde = nomSauvegarde;

        // Configurer le texte du bouton
        this.setText(nomSauvegarde);

        // Redimensionner l'image
        Image scaledImage = imageTamagotchi.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        // Configurer l'icône du bouton avec l'image redimensionnée
        this.setIcon(new ImageIcon(scaledImage));

        // Ajouter un ActionListener pour gérer le clic sur le bouton
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Gérer le chargement de la sauvegarde
                chargerSauvegarde();
            }
        });
    }

    private void chargerSauvegarde() {
        // Logique pour charger la sauvegarde associée
        System.out.println("Charger la sauvegarde : " + nomSauvegarde);
    }
}
