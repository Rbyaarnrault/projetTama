package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonSauvegarde extends JButton {

    private String nomSauvegarde;

    public BoutonSauvegarde(String nomSauvegarde, Image imageTamagotchi, String dateDerniereSauvegarde) {
        this.nomSauvegarde = nomSauvegarde;

        // Créer un JPanel personnalisé avec le layout souhaité
        JPanel panel = new JPanel(new BorderLayout());
        JLabel labelNom = new JLabel(nomSauvegarde);
        JLabel labelImage = new JLabel(new ImageIcon(imageTamagotchi));
        JLabel labelDate = new JLabel(dateDerniereSauvegarde);

        // Ajouter les composants au JPanel
        panel.add(labelNom, BorderLayout.NORTH);
        panel.add(labelImage, BorderLayout.CENTER);
        panel.add(labelDate, BorderLayout.SOUTH);

        // Utiliser le JPanel comme composant du bouton
        this.add(panel);

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
