package vue;

import javax.swing.*;

import controlleur.TamagotchiControleur;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class EcranSauvegardes extends JPanel {

    private TamagotchiControleur controleur;
    private String repertoireSauvegardes = "Tamagotchi/src/ressources/sauvegardes"; // Remplacez par le chemin réel

    public EcranSauvegardes(TamagotchiControleur controleur) {
        this.controleur = controleur;

        this.setLayout(new BorderLayout());
        Box verticalBox = Box.createVerticalBox();

        // Récupérez la liste des fichiers de sauvegarde dans le répertoire
        File repertoire = new File(repertoireSauvegardes);
        File[] fichiersSauvegarde = repertoire.listFiles();

        // Parcourez chaque fichier et créez un bouton pour chaque sauvegarde existante
        if (fichiersSauvegarde != null) {
            verticalBox.add(Box.createVerticalStrut(40));
            for (File fichier : fichiersSauvegarde) {
                if (fichier.isFile() && fichier.getName().endsWith(".dat")) { // Seulement les fichiers en .dat

                    BoutonSauvegarde bouton = creerSauvegardeButton(fichier);

                    // Associez chaque bouton à la sauvegarde correspondante
                    final String nomFichier = fichier.getAbsolutePath();
                    bouton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            chargerSauvegarde(nomFichier);
                        }
                    });

                    bouton.setAlignmentX(Component.CENTER_ALIGNMENT);
                    // Ajoute le bouton à l'interface utilisateur
                    verticalBox.add(bouton);

                    // Ajoute un espace vertical (décalage) entre les boutons
                    verticalBox.add(Box.createVerticalGlue()); // Add flexible space

                    this.add(verticalBox, BorderLayout.CENTER);
                }
            }

            verticalBox.add(Box.createVerticalStrut(40));
        } else {
            System.out.println("Répertoire " + repertoireSauvegardes + " vide/inconnu");
        }

    }

    private BoutonSauvegarde creerSauvegardeButton(File fichier) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))) {
            String nomSauvegarde = fichier.getName().replace(".dat", ""); // Retirez l'extension;

            // Vous pouvez ignorer la lecture de la chaîne (elle est déjà lue dans Partie)
            ois.readObject(); // Ignorer la chaîne

            String cheminImage = (String) ois.readObject();
            Image img = new ImageIcon(cheminImage).getImage();

            // Créez et retournez un nouveau bouton SauvegardeButton
            return new BoutonSauvegarde(nomSauvegarde, img);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la lecture de l'image : " + e.getMessage());
            return null;
        }
    }

    private void chargerSauvegarde(String nomFichier) {
        controleur.chargerPartie(nomFichier);
    }

}
