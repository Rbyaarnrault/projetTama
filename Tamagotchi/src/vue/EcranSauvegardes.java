package vue;

import javax.swing.*;

import controlleur.TamagotchiControleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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
                if (fichier.isFile()) {
                    String nomUnique = fichier.getName().replace(".dat", ""); // Retirez l'extension
                    JButton bouton = new JButton(nomUnique);

                    // Associez chaque bouton à la sauvegarde correspondante
                    final String nomFichier = fichier.getAbsolutePath();
                    bouton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            chargerSauvegarde(nomFichier);
                        }
                    });

                    // Ajoutez le bouton à l'interface utilisateur
                    this.add(bouton);
                }
            }
        } else {
            System.out.println("Répertoire " + repertoireSauvegardes + " vide/inconnu");
        }

        // Autres configurations de l'interface utilisateur...
    }

    private void chargerSauvegarde(String nomFichier) {
        controleur.chargerPartie(nomFichier);
        ;
        // Actualisez l'interface utilisateur avec les détails de la sauvegarde chargée
        // ...
        System.out.println("Sauvegarde " + nomFichier + " chargée !");
    }

}
