package vue;

import javax.swing.*;

import controlleur.TamagotchiControleur;
import util.ImageUtils;

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

        // Utilisez un layout de type BoxLayout pour disposer les boutons verticalement
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Récupérez la liste des fichiers de sauvegarde dans le répertoire
        File repertoire = new File(repertoireSauvegardes);
        File[] fichiersSauvegarde = repertoire.listFiles();

        // Parcourez chaque fichier et créez un bouton pour chaque sauvegarde existante
        if (fichiersSauvegarde != null) {
            for (File fichier : fichiersSauvegarde) {
                if (fichier.isFile() && fichier.getName().endsWith(".dat")) { // Seulement les fichiers en .dat

                    // BoutonSauvegarde bouton = creerSauvegardeButton(fichier);
                    JButton bouton1 = new JButton(fichier.getName());
                    // Associez chaque bouton à la sauvegarde correspondante
                    final String nomFichier = fichier.getAbsolutePath();
                    bouton1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            chargerSauvegarde(nomFichier);
                        }
                    });

                    // Ajoutez le bouton à l'interface utilisateur
                    // this.add(bouton);
                    this.add(bouton1);
                }
            }
        } else {
            System.out.println("Répertoire " + repertoireSauvegardes + " vide/inconnu");
        }
        // Autres configurations de l'interface utilisateur...
    }

    private BoutonSauvegarde creerSauvegardeButton(File fichier) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))) {
            String nomSauvegarde = fichier.getName().replace(".dat", ""); // Retirez l'extension;

            // Vous pouvez ignorer la lecture de la chaîne (elle est déjà lue dans Partie)
            ois.readObject(); // Ignorer la chaîne

            // Charger l'image directement depuis le fichier
            Image image = ImageUtils.loadImageFromPath(fichier.getAbsolutePath());

            // Créez et retournez un nouveau bouton SauvegardeButton
            return new BoutonSauvegarde(nomSauvegarde, image);

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
