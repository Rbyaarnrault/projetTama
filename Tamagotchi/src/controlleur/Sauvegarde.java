package controlleur;

import java.io.*;

import javax.swing.ImageIcon;
import modele.Partie;

public class Sauvegarde {

    public void sauvegarderPartie(Partie partie, String nomFichier) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomFichier))) {

            System.out.println("Chargement de l'image : " + partie.getTamagotchi().getImage());

            oos.writeObject(partie);

            // Seul moyen pour stocker le chemin d'accès de l'image
            // En stockant dans l'objet l'url de l'image

            oos.writeObject(partie.getTamagotchi().getCheminImage());

            System.out.println("Partie sauvegardée avec succès dans " + nomFichier);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Partie chargerPartie(String nomFichier) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomFichier))) {
            Object obj = ois.readObject();

            if (obj instanceof Partie) {
                // Me permet de voir le contenu de partie en debug pour voir si tout est
                // fonctionnel
                Partie partie = (Partie) obj;

                String cheminImage = (String) ois.readObject();
                partie.getTamagotchi().setImage(new ImageIcon(cheminImage).getImage());

                return partie;
            } else {
                System.out.println("Le fichier ne contient pas une instance de Partie.");
                return null;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la lecture de la sauvegarde : " + e.getMessage());
            return null;
        }
    }
}
